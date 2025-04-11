import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int frameWidth = 360;
    int frameHeight = 640;

    // Images
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    // Player
    int playerStartPosX = frameWidth / 8;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;
    Player player;

    // Pipes
    ArrayList<Pipe> pipes;
    Timer pipeSpawnTimer;
    Random random = new Random();

    // Game loop
    Timer gameLoop;

    // Game state
    boolean gameOver = false;

    // Score
    int score = 0;
    JLabel scoreLabel;

    public FlappyBird() {
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);
        setLayout(null);

        // Load images
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        // Setup player
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);

        // Setup pipes
        pipes = new ArrayList<>();
        placePipe();

        pipeSpawnTimer = new Timer(2000, e -> {
            if (!gameOver) placePipe();
        });
        pipeSpawnTimer.start();

        // Game loop
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();

        // Score label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setBounds(10, 10, 200, 30);
        add(scoreLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null);

        for (Pipe pipe : pipes) {
            pipe.draw(g);
        }

        player.draw(g);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("GAME OVER", 80, frameHeight / 2);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press 'R' to Restart", 85, frameHeight / 2 + 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            player.applyGravity();

            for (Pipe pipe : pipes) {
                pipe.move();

                // Tabrakan
                Rectangle playerRect = new Rectangle(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight());
                Rectangle pipeRect = new Rectangle(pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight());

                if (playerRect.intersects(pipeRect)) {
                    gameOver = true;
                }

                // Tambah skor saat lewati pipa atas & belum dihitung
                if (!pipe.isBottom() && !pipe.isScored() && pipe.getX() + pipe.getWidth() < player.getPosX()) {
                    pipe.setScored(true);
                    score++;
                    scoreLabel.setText("Score: " + score);
                }
            }

            // Jatuh ke bawah
            if (player.getPosY() + player.getHeight() > frameHeight) {
                gameOver = true;
            }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (!gameOver) {
            if (key == KeyEvent.VK_SPACE) {
                player.setVelocityY(-10);
            }
        } else {
            if (key == KeyEvent.VK_R) {
                restartGame();
            }
        }
    }

    public void restartGame() {
        gameOver = false;
        score = 0;
        scoreLabel.setText("Score: 0");

        player.setPosX(playerStartPosX);
        player.setPosY(playerStartPosY);
        player.setVelocityY(0);

        pipes.clear();
        placePipe();
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    public void placePipe() {
        int pipeWidth = 64;
        int pipeHeight = 512;
        int spaceBetween = 150;
        int pipeX = frameWidth;

        int offset = random.nextInt(200) - 100;

        int upperY = -pipeHeight / 2 + offset;
        int lowerY = upperY + pipeHeight + spaceBetween;

        pipes.add(new Pipe(pipeX, upperY, pipeWidth, pipeHeight, false, upperPipeImage));
        pipes.add(new Pipe(pipeX, lowerY, pipeWidth, pipeHeight, true, lowerPipeImage));
    }
}
