import javax.swing.JFrame;

import entities.Door;
import entities.Maze;
import entities.Room;
import entities.Wall;
import entities.enchanted.DoorNeedingSpell;
import entities.enchanted.EnchantedRoom;
import factory.MazeFactory;
import factory.MazeGame;
import prototype.EnchantedMazePrototypeFactory;
import prototype.MazePrototypeFactory;
import ui.GameWindow;

public class App extends JFrame {
    private static final long serialVersionUID = 949744218770101004L;

    public static void main(String[] args) {
        // MazeFactory factory = new MazePrototypeFactory(new Maze(), new Wall(), new
        // Room(), new Door());
        MazeFactory factory = new EnchantedMazePrototypeFactory(new Maze(), new Wall(), new EnchantedRoom(),
                new DoorNeedingSpell());
        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze(factory);

        GameWindow gw = new GameWindow();
        gw.startGame(maze);
    }
}
