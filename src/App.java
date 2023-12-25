import javax.swing.JFrame;

import entities.Maze;
import factory.DefaultMazeFactory;
import factory.EnchantedMazeFactory;
import factory.MazeFactory;
import factory.MazeGame;
import ui.GameWindow;

public class App extends JFrame {
    private static final long serialVersionUID = 949744218770101004L;

    public static void main(String[] args) {
        //MazeFactory factory = new DefaultMazeFactory();
        MazeFactory factory = new EnchantedMazeFactory();
        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze(factory);

        GameWindow gw = new GameWindow();
        gw.startGame(maze);
    }
}
