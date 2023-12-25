package entities.enchanted;

import models.Model;
import java.awt.Rectangle;

public class Key extends Model {
    private static final String IMG_PATH_KEY = "res/Key_noBg.png";

    public Key() {
        super(IMG_PATH_KEY);
    }

    public Key(Key m) {
        this.x = m.x;
        this.y = m.y;
        this.image = m.image;
        this.width = m.width;
        this.height = m.height;
        this.visible = m.visible;
    }

    @Override
    public Model clone() {
        return new Key(this);
    }

    public boolean checkIntersect(Rectangle rp) {
        if (rp.intersects(this.getBounds())) {
            this.setVisible(false);
            return true;
        }

        return false;
    }
}
