package entities.enchanted;

import models.Model;
import java.awt.Rectangle;

public class Key extends Model {
    private static final String IMG_PATH_KEY = "res/Key_noBg.png";

    public Key() {
        super(IMG_PATH_KEY);
    }

    public boolean checkIntersect(Rectangle rp) {
        if (rp.intersects(this.getBounds())) {
            this.setVisible(false);
            return true;
        }

        return false;
    }
}
