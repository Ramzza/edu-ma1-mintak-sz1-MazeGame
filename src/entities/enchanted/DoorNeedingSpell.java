package entities.enchanted;

import entities.Door;
import entities.Room;

public class DoorNeedingSpell extends Door {

    public DoorNeedingSpell(Room a, Room b) {
        super(a, b);
        this.setIsOpen(false);
    }

    @Override
    public void enter() {
        if (this.collisionString.equals("Door") && !this.getIsOpen() && this.logEnter) {
            String logText = "Ajto " + this.room1.getRoomNumber() + "/" + this.room2.getRoomNumber() + " - zarva";
            System.out.println(logText);
        } else {
            super.enter();
        }
    }

}
