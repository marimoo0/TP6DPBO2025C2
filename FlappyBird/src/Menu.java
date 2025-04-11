import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Flappy Bird - Menu");
        setSize(360, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Background color (seperti langit)
        getContentPane().setBackground(new Color(113, 197, 207));

        // Judul
        JLabel title = new JLabel("FlappyBird");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.DARK_GRAY);
        title.setBounds(90, 30, 300, 50);
        add(title);

        // Gambar burung
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("assets/bird.png")); // Sesuaikan path
        Image scaledImg = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon birdIcon = new ImageIcon(scaledImg);
        JLabel birdLabel = new JLabel(birdIcon);
        birdLabel.setBounds(130, 100, 100, 100);
        add(birdLabel);

        // Tombol Play
        JButton playButton = new JButton("PLAY");
        playButton.setFont(new Font("Arial", Font.BOLD, 24));
        playButton.setBounds(100, 250, 160, 60);
        playButton.setFocusPainted(false);
        playButton.setBackground(Color.WHITE);
        playButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        add(playButton);

        // Action: Start Game
        playButton.addActionListener(e -> {
            dispose(); // Tutup menu
            openGameWindow();
        });

        setVisible(true);
    }

    private void openGameWindow() {
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 640);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        frame.setVisible(true);
    }
}
