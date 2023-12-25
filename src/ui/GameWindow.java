package ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import entities.Maze;

public class GameWindow extends JFrame {
    private static final long serialVersionUID = 2282316902617003954L;

    public void startGame(Maze maze) {
        add(new Palya(maze));

        setResizable(false);
        pack();

        setTitle("Maze");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
