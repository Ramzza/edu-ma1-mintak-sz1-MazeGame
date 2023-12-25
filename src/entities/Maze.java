package entities;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

import models.Jatekos;
import models.Model;

public class Maze {
    private static final int MAP_SIZE = 4;

    private ArrayList<Room> rooms;
    private Room oldRoom;

    public Maze() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room a) {
        this.rooms.add(a);
    }

    public Room roomNo(int n) {
        return this.rooms.get(n);
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public List<Model> getMazeModels() {
        ArrayList<Model> models = new ArrayList<>();
        for (int i = 0; i < this.rooms.size(); i++) {
            models.addAll(this.roomNo(i).getModels());
        }
        return models;
    }

    public boolean canPlayerMove(Jatekos player) {
        return !this.checkCollisionWithWall(player.getBounds());
    }

    protected boolean checkCollisionWithWall(Rectangle rp) {
        ArrayList<Integer> playerRooms = (ArrayList<Integer>) this.playerInRoom(rp);
        Room room;
        Room currentRoom;
        MapSite ms;

        currentRoom = this.rooms.get(playerRooms.get(0));

        if (currentRoom != this.oldRoom) {
            this.oldRoom = currentRoom;
            currentRoom = this.rooms.get(playerRooms.get(0));
            currentRoom.enter();
        }

        for (int j = 0; j < playerRooms.size(); j++) {
            room = this.roomNo(playerRooms.get(j));
            for (int i = 0; i < 4; i++) {
                ms = room.getSide(i);

                if (ms.intersectsWith(rp)) {
                    ms.enter();
                    return true;
                }
            }
        }

        return false;
    }

    private List<Integer> playerInRoom(Rectangle rp) {
        ArrayList<Integer> playerRooms = new ArrayList<>();

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            if (this.roomNo(i).intersectsWith(rp)) {
                playerRooms.add(i);
                if (playerRooms.size() == 2) {
                    return playerRooms;
                }
            }
        }

        return playerRooms;
    }
}
