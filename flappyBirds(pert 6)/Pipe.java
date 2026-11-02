import java.awt.Image;

public class Pipe {
    int posX;
    int posY;
    int width;
    int height;
    Image img;
    boolean passed = false; // Untuk pengecekan skor ketika dilewati player

    public Pipe(int posX, int posY, int width, int height, Image img) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.img = img;
    }

    // Getter dan Setter
    public int getPosX() { return posX; }
    public void setPosX(int posX) { this.posX = posX; }

    public int getPosY() { return posY; }
    public void setPosY(int posY) { this.posY = posY; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public Image getImg() { return img; }
    public void setImg(Image img) { this.img = img; }

    public boolean isPassed() { return passed; }
    public void setPassed(boolean passed) { this.passed = passed; }
}