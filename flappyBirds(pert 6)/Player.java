import java.awt.Image;

public class Player {
    int posX;
    int posY;
    int width;
    int height;
    Image img;
    int velocityY = 0; // Untuk efek gravitasi dan lompat

    public Player(int posX, int posY, int width, int height, Image img) {
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

    public int getVelocityY() { return velocityY; }
    public void setVelocityY(int velocityY) { this.velocityY = velocityY; }
}