package entities;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import models.Model;

public class Wall extends MapSite {
    private static final String IMG_PATH_WALL = "res/Wall.png";

    public Wall() {
        this.initWall();
    }

    public void enter() {
        System.out.println("Fal - utkozes");
    }

    protected void calculateSize(int x, int y, int width, int height) {
        Model model;

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        for (int i = 0; i < ROOM_SIZE; i++) {
            x = (width == 1) ? this.x : this.x + i * WALL_SIZE;
            y = (height == 1) ? this.y : this.y + i * WALL_SIZE;
            model = this.models.get(i);
            model.setPosition(x, y);
        }
    }

    private void initWall() {
        Model model;
        this.models = new ArrayList<>();

        for (int i = 0; i < ROOM_SIZE; i++) {
            model = new Model(IMG_PATH_WALL);
            this.models.add(model);
        }
    }

    @Override
    public boolean intersectsWith(Rectangle rect) {
        Rectangle bigWall = new Rectangle(this.x, this.y, this.width * WALL_SIZE, this.height * WALL_SIZE);
        return (bigWall.intersects(rect));
    }

    @Override
    protected List<Model> getModels() {
        return this.models;
    }
}
