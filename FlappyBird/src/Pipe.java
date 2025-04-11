import java.awt.*;
import javax.swing.*;

public class Pipe {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isBottom;
    private Image image;
    private boolean scored = false;

    public Pipe(int x, int y, int width, int height, boolean isBottom, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isBottom = isBottom;
        this.image = image;
    }

    public void move() {
        x -= 3;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    // Getters and Setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public boolean isBottom() { return isBottom; }
    public void setBottom(boolean bottom) { isBottom = bottom; }

    public Image getImage() { return image; }
    public void setImage(Image image) { this.image = image; }

    public boolean isScored() { return scored; }
    public void setScored(boolean scored) { this.scored = scored; }
}
