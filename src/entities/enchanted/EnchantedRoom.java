package entities.enchanted;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Rectangle;

import entities.Room;
import models.Model;

public class EnchantedRoom extends Room {

    private Key key;

    public EnchantedRoom(int roomNo) {
        super(roomNo);
        this.key = new Key();
    }

    public boolean hasKey() {
        return this.key.isVisible();
    }

    @Override
    protected void calculateSize(int x, int y, int width, int height) {
        int keyX;
        int keyY;
        super.calculateSize(x, y, width, height);

        keyX = ThreadLocalRandom.current().nextInt(x + WALL_SIZE, x + width - WALL_SIZE + 1);
        keyY = ThreadLocalRandom.current().nextInt(y + WALL_SIZE, y + height - WALL_SIZE + 1);

        this.key.setPosition(keyX, keyY);
    }

    @Override
    public boolean intersectsWith(Rectangle rect) {
        if (this.key.checkIntersect(rect)) {
            for (int i = 0; i < this.doors.size(); i++) {
                this.doors.get(i).setIsOpen(true);
            }
        }
        return super.intersectsWith(rect);
    }

    @Override
    protected List<Model> getModels() {
        List<Model> models = super.getModels();
        models.add(this.key);

        return models;
    }

}
