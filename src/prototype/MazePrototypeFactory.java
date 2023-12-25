package prototype;

import entities.Door;
import entities.Maze;
import entities.Room;
import entities.Wall;
import factory.MazeFactory;

public class MazePrototypeFactory implements MazeFactory {

    private Maze prototypeMaze;
    private Room prototypeRoom;
    private Wall prototypeWall;
    private Door prototypeDoor;

    public MazePrototypeFactory(Maze m, Wall w, Room r, Door d) {
        this.prototypeMaze = m;
        this.prototypeWall = w;
        this.prototypeRoom = r;
        this.prototypeDoor = d;
    }

    public Maze makeMaze() {
        return this.prototypeMaze.clone();
    }

    public Room makeRoom(int roomNo) {
        Room r = this.prototypeRoom.clone();
        r.initialize(roomNo);
        return r;
    }

    public Wall makeWall() {
        Wall w = this.prototypeWall.clone();
        w.initialize();
        return w;
    }

    public Door makeDoor(Room r1, Room r2) {
        Door door = this.prototypeDoor.clone();
        door.initialize(r1, r2);

        return door;
    }

}
