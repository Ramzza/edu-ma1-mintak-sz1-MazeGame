package prototype;

import entities.Door;
import entities.Maze;
import entities.Room;
import entities.Wall;
import entities.enchanted.DoorNeedingSpell;
import entities.enchanted.EnchantedRoom;
import factory.MazeFactory;

public class EnchantedMazePrototypeFactory implements MazeFactory {

    private Maze prototypeMaze;
    private EnchantedRoom prototypeRoom;
    private Wall prototypeWall;
    private DoorNeedingSpell prototypeDoor;

    public EnchantedMazePrototypeFactory(Maze m, Wall w, EnchantedRoom r, DoorNeedingSpell d) {
        this.prototypeMaze = m;
        this.prototypeWall = w;
        this.prototypeRoom = r;
        this.prototypeDoor = d;
    }

    public Maze makeMaze() {
        return this.prototypeMaze.clone();
    }

    public Room makeRoom(int roomNo) {
        EnchantedRoom r = this.prototypeRoom.clone();
        r.initialize(roomNo);
        return r;
    }

    public Wall makeWall() {
        Wall w = this.prototypeWall.clone();
        w.initialize();
        return w;
    }

    public Door makeDoor(Room r1, Room r2) {
        DoorNeedingSpell door = this.prototypeDoor.clone();
        door.initialize(r1, r2);

        return door;
    }
}
