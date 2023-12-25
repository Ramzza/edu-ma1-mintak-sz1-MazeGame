package factory;

import entities.Direction;
import entities.Door;
import entities.Maze;
import entities.Room;

public class MazeGame {

    public Maze createMaze(MazeFactory factory) {
        Maze aMaze = factory.makeMaze();
        Room r0 = factory.makeRoom(0);
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        Room r3 = factory.makeRoom(3);
        Room r4 = factory.makeRoom(4);
        Room r5 = factory.makeRoom(5);
        Room r6 = factory.makeRoom(6);
        Room r7 = factory.makeRoom(7);
        Room r8 = factory.makeRoom(8);
        Room r9 = factory.makeRoom(9);
        Room r10 = factory.makeRoom(10);
        Room r11 = factory.makeRoom(11);
        Room r12 = factory.makeRoom(12);
        Room r13 = factory.makeRoom(13);
        Room r14 = factory.makeRoom(14);
        Room r15 = factory.makeRoom(15);
        Door door1to2 = factory.makeDoor(r0, r1);
        Door door2to6 = factory.makeDoor(r1, r5);
        Door door5to6 = factory.makeDoor(r4, r5);
        Door door5to9 = factory.makeDoor(r4, r8);
        Door door9to13 = factory.makeDoor(r8, r12);
        Door door13to14 = factory.makeDoor(r12, r13);
        Door door14to10 = factory.makeDoor(r13, r9);
        Door door10to11 = factory.makeDoor(r9, r10);
        Door door11to7 = factory.makeDoor(r10, r6);
        Door door7to3 = factory.makeDoor(r6, r2);
        Door door3to4 = factory.makeDoor(r2, r3);
        Door door4to8 = factory.makeDoor(r3, r7);
        Door door8to12 = factory.makeDoor(r7, r11);
        Door door12to16 = factory.makeDoor(r11, r15);
        Door door16to15 = factory.makeDoor(r15, r14);

        r0.setSide(Direction.NORTH, factory.makeWall());
        r0.setSide(Direction.EAST, factory.makeWall());
        r0.setSide(Direction.SOUTH, door1to2);
        r0.setSide(Direction.WEST, factory.makeWall());

        r1.setSide(Direction.NORTH, door1to2);
        r1.setSide(Direction.EAST, door2to6);
        r1.setSide(Direction.SOUTH, factory.makeWall());
        r1.setSide(Direction.WEST, factory.makeWall());

        r2.setSide(Direction.NORTH, factory.makeWall());
        r2.setSide(Direction.EAST, door7to3);
        r2.setSide(Direction.SOUTH, door3to4);
        r2.setSide(Direction.WEST, factory.makeWall());

        r3.setSide(Direction.NORTH, door3to4);
        r3.setSide(Direction.EAST, door4to8);
        r3.setSide(Direction.SOUTH, factory.makeWall());
        r3.setSide(Direction.WEST, factory.makeWall());

        r4.setSide(Direction.NORTH, factory.makeWall());
        r4.setSide(Direction.EAST, door5to9);
        r4.setSide(Direction.SOUTH, door5to6);
        r4.setSide(Direction.WEST, factory.makeWall());

        r5.setSide(Direction.NORTH, door5to6);
        r5.setSide(Direction.EAST, factory.makeWall());
        r5.setSide(Direction.SOUTH, factory.makeWall());
        r5.setSide(Direction.WEST, door2to6);

        r6.setSide(Direction.NORTH, factory.makeWall());
        r6.setSide(Direction.EAST, door11to7);
        r6.setSide(Direction.SOUTH, factory.makeWall());
        r6.setSide(Direction.WEST, door7to3);

        r7.setSide(Direction.NORTH, factory.makeWall());
        r7.setSide(Direction.EAST, door8to12);
        r7.setSide(Direction.SOUTH, factory.makeWall());
        r7.setSide(Direction.WEST, door4to8);

        r8.setSide(Direction.NORTH, factory.makeWall());
        r8.setSide(Direction.EAST, door9to13);
        r8.setSide(Direction.SOUTH, factory.makeWall());
        r8.setSide(Direction.WEST, door5to9);

        r9.setSide(Direction.NORTH, factory.makeWall());
        r9.setSide(Direction.EAST, door14to10);
        r9.setSide(Direction.SOUTH, door10to11);
        r9.setSide(Direction.WEST, factory.makeWall());

        r10.setSide(Direction.NORTH, door10to11);
        r10.setSide(Direction.EAST, factory.makeWall());
        r10.setSide(Direction.SOUTH, factory.makeWall());
        r10.setSide(Direction.WEST, door11to7);

        r11.setSide(Direction.NORTH, factory.makeWall());
        r11.setSide(Direction.EAST, door12to16);
        r11.setSide(Direction.SOUTH, factory.makeWall());
        r11.setSide(Direction.WEST, door8to12);

        r12.setSide(Direction.NORTH, factory.makeWall());
        r12.setSide(Direction.EAST, factory.makeWall());
        r12.setSide(Direction.SOUTH, door13to14);
        r12.setSide(Direction.WEST, door9to13);

        r13.setSide(Direction.NORTH, door13to14);
        r13.setSide(Direction.EAST, factory.makeWall());
        r13.setSide(Direction.SOUTH, factory.makeWall());
        r13.setSide(Direction.WEST, door14to10);

        r14.setSide(Direction.NORTH, factory.makeWall());
        r14.setSide(Direction.EAST, factory.makeWall());
        r14.setSide(Direction.SOUTH, door16to15);
        r14.setSide(Direction.WEST, factory.makeWall());

        r15.setSide(Direction.NORTH, door16to15);
        r15.setSide(Direction.EAST, factory.makeWall());
        r15.setSide(Direction.SOUTH, factory.makeWall());
        r15.setSide(Direction.WEST, door12to16);

        aMaze.addRoom(r0);
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        aMaze.addRoom(r3);
        aMaze.addRoom(r4);
        aMaze.addRoom(r5);
        aMaze.addRoom(r6);
        aMaze.addRoom(r7);
        aMaze.addRoom(r8);
        aMaze.addRoom(r9);
        aMaze.addRoom(r10);
        aMaze.addRoom(r11);
        aMaze.addRoom(r12);
        aMaze.addRoom(r13);
        aMaze.addRoom(r14);
        aMaze.addRoom(r15);

        return aMaze;
    }
}
