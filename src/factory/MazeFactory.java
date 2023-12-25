package factory;

import entities.Door;
import entities.Maze;
import entities.Room;
import entities.Wall;

public interface MazeFactory {
    public Maze makeMaze();
    public Wall makeWall();
    public Room makeRoom(int n);
    public Door makeDoor(Room r1, Room r2);
}
