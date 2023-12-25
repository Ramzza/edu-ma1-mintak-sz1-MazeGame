package entities;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

import models.Model;

public abstract class MapSite {
    protected static final int MAP_SIZE = 4;
    protected static final int ROOM_SIZE = 8;
    protected static final int WALL_SIZE = 32;
    protected ArrayList<Model> models;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public abstract void enter();

    public abstract boolean intersectsWith(Rectangle rect);

    protected abstract void calculateSize(int x, int y, int width, int height);

    protected abstract List<Model> getModels();

    protected int getX() {
        return this.x;
    }

    protected int getY() {
        return this.y;
    }

    protected int getWidth() {
        return this.width;
    }

    protected int getHeight() {
        return this.height;
    }
}
