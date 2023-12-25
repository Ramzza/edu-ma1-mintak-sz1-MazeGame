package entities;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

import models.Model;

public class Door extends MapSite {
    private static final String IMG_PATH_DOOR = "res/Door_noBg.png";
    private static final String IMG_PATH_WALL = "res/Wall.png";

    protected Room room1;
    protected Room room2;
    private int innerHeight;
    protected boolean logEnter = true;
    protected String collisionString;

    private boolean isOpen;
    private int innerX;
    private int innerY;
    private int innerWidth;

    public Door(Room a, Room b) {
        this.room1 = a;
        this.room2 = b;
        this.isOpen = true;
        this.initDoor();
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void enter() {
        String logText;
        if (this.collisionString.equals("Door") && this.logEnter && this.isOpen) {
            logText = "Ajto " + this.room1.getRoomNumber() + "/" + this.room2.getRoomNumber() + " - atlepes";
            System.out.println(logText);
        } else if (this.collisionString.equals("Wall")) {
            logText = "Fal - utkozes";
            logEnter = true;
            System.out.println(logText);
        }
    }

    public Room otherSideFrom(Room a) {
        if (a == this.room1) {
            return this.room2;
        } else {
            return this.room1;
        }
    }

    @Override
    public boolean intersectsWith(Rectangle rect) {
        Rectangle bigWall = new Rectangle(this.x, this.y, this.width * WALL_SIZE, this.height * WALL_SIZE);

        int x = (this.innerX == this.x) ? this.x : this.innerX + this.innerWidth * WALL_SIZE;
        int y = (this.innerY == this.y) ? this.y : this.innerY + this.innerHeight * WALL_SIZE;
        int width = (this.innerX == this.x) ? WALL_SIZE : this.innerX - this.x;
        int height = (this.innerY == this.y) ? WALL_SIZE : this.innerY - this.y;

        Rectangle rLeft = new Rectangle(this.x, this.y, width, height);
        Rectangle rRight = new Rectangle(x, y, width, height);

        if (this.intersectsDoor(bigWall, rLeft, rRight, rect)) {
            if (this.isOpen) {
                this.models.get(3).setVisible(false);
                this.models.get(4).setVisible(false);
            }
            this.collisionString = "Door";
            this.enter();
            this.logEnter = false;
        } else {
            this.logEnter = true;
            this.collisionString = "Wall";
        }

        return this.checkIntersection(bigWall, rLeft, rRight, rect);
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

        this.calculateInnerSize();
    }

    @Override
    protected List<Model> getModels() {
        return this.models;
    }

    private boolean intersectsDoor(Rectangle bigWall, Rectangle rLeft, Rectangle rRight, Rectangle player) {
        return bigWall.intersects(player) && !rLeft.intersects(player) && !rRight.intersects(player);
    }

    private boolean checkIntersection(Rectangle bigWall, Rectangle rLeft, Rectangle rRight, Rectangle player) {
        if (this.isOpen) {
            return (bigWall.intersects(player) && !this.intersectsDoor(bigWall, rLeft, rRight, player));
        } else {
            return (bigWall.intersects(player));
        }
    }

    private void calculateInnerSize() {
        Model model = this.models.get(3);

        this.innerX = model.getX();
        this.innerY = model.getY();

        if (this.width == 1) {
            this.innerHeight = 2;
            this.innerWidth = 1;
        } else {
            this.innerWidth = 2;
            this.innerHeight = 1;
        }
    }

    private void initDoor() {
        Model model;
        int doorSide = ROOM_SIZE / 4;
        this.models = new ArrayList<>();

        for (int i = 0; i < ROOM_SIZE; i++) {
            if (i > doorSide && i < ROOM_SIZE - 1 - doorSide) {
                model = new Model(IMG_PATH_DOOR);
                this.models.add(model);
            } else {
                model = new Model(IMG_PATH_WALL);
                this.models.add(model);
            }
        }

    }
}
