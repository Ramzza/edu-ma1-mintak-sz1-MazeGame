package models;

import java.awt.event.KeyEvent;

public class Jatekos extends Model {
    private static final String IMG_PATH_PLAYER = "res/Player_noBg.png";
    private int dx;
    private int dy;

    public Jatekos(int x, int y) {
        super(x, y, IMG_PATH_PLAYER);
    }

    public void move() {
        this.x += dx;
        this.y += dy;

        if (this.x < 1) {
            this.x = 1;
        }

        if (this.y < 1) {
            this.y = 1;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int speed = 8;

        if (key == KeyEvent.VK_LEFT) {
            dx = -speed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = speed;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -speed;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = speed;
        }
    }

    public void unMove() {
        this.x -= dx;
        this.y -= dy;

        if (this.x < 1) {
            this.x = 1;
        }

        if (this.y < 1) {
            this.y = 1;
        }

        dx = 0;
        dy = 0;
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
