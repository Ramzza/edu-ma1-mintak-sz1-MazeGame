package factory;

import entities.Door;
import entities.Maze;
import entities.Room;
import entities.Wall;
import entities.enchanted.DoorNeedingSpell;
import entities.enchanted.EnchantedRoom;

public class EnchantedMazeFactory implements MazeFactory {

    public Maze makeMaze() {
        return new Maze();
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Room makeRoom(int n) {
        return new EnchantedRoom(n);
    }

    public Door makeDoor(Room r1, Room r2) {
        return new DoorNeedingSpell(r1, r2);
    }

}