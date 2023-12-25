package models;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Model {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Model(int x, int y) {
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    public Model(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.visible = true;
        this.init(path);
    }

    public Model(String path) {
        this.visible = true;
        this.init(path);
    }

    protected void init(String path) {
        this.loadImage(path);
        this.getImageDimensions();
    }

    protected void getImageDimensions() {

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    private void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}
