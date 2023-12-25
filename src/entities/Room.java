package entities;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import models.Model;

public class Room extends MapSite {
    private MapSite[] sides;
    private int roomNumber;
    protected ArrayList<Door> doors;

    public Room() {
        this.init();
    }

    public Room(int roomNo) {
        this.sides = new MapSite[4];
        this.initialize(roomNo);
    }

    public Room(Room r) {
        this.roomNumber = r.roomNumber;
        this.doors = r.doors;
        this.sides = r.sides;
    }

    public Room clone() {
        return new Room(this);
    }

    private void init() {
        this.sides = new MapSite[4];
        this.doors = new ArrayList<>();
        this.roomNumber = 0;
        this.x = 0;
        this.y = 0;

        this.width = 0;
        this.height = 0;
    }

    public void initialize(int roomNo) {
        this.sides = new MapSite[4];
        this.doors = new ArrayList<>();
        this.roomNumber = roomNo;
        this.x = roomNo / MAP_SIZE * (ROOM_SIZE - 1) * WALL_SIZE;
        this.y = roomNo % MAP_SIZE * (ROOM_SIZE - 1) * WALL_SIZE;

        this.width = (ROOM_SIZE - 1) * WALL_SIZE;
        this.height = this.width;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public MapSite getSide(int d) {
        return this.sides[d];
    }

    public void setSide(int d, MapSite m) {
        if (m instanceof Door) {
            this.doors.add((Door) m);
        }
        this.sides[d] = m;
    }

    public void enter() {
        System.out.println("Szoba #" + this.roomNumber + " - belepes");
    }

    @Override
    public boolean intersectsWith(Rectangle rect) {
        Rectangle room = new Rectangle(this.x, this.y, this.width, this.height);
        return (room.intersects(rect));
    }

    @Override
    protected List<Model> getModels() {
        this.calculateSize(this.x, this.y, this.width, this.height);
        ArrayList<Model> models = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            models.addAll(this.sides[i].getModels());
        }
        return models;
    }

    protected void calculateSize(int x, int y, int width, int height) {
        MapSite mapSite;

        mapSite = this.getSide(Direction.NORTH);
        mapSite.calculateSize(this.x, this.y, ROOM_SIZE - 1, 1);

        mapSite = this.getSide(Direction.SOUTH);
        mapSite.calculateSize(this.x, this.y + (ROOM_SIZE - 1) * WALL_SIZE, ROOM_SIZE - 1, 1);

        mapSite = this.getSide(Direction.WEST);
        mapSite.calculateSize(this.x, this.y, 1, ROOM_SIZE - 1);

        mapSite = this.getSide(Direction.EAST);
        mapSite.calculateSize(this.x + (ROOM_SIZE - 1) * WALL_SIZE, this.y, 1, ROOM_SIZE - 1);
    }

}
