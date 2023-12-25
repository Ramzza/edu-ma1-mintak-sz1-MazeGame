package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import entities.Maze;
import models.Jatekos;
import models.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Palya extends JPanel implements ActionListener {
    private static final long serialVersionUID = -5313522753489154931L;
    private static final int MAP_SIZE = 4;
    private static final int ROOM_SIZE = 8;
    private static final int WALL_SIZE = 32;

    private Maze maze;
    private Jatekos player;
    private ArrayList<Model> objektumok;

    public Palya(Maze maze) {
        this.maze = maze;
        this.objektumok = (ArrayList<Model>) this.maze.getMazeModels();

        initPalya();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        if (!this.maze.canPlayerMove(player)) {
            player.unMove();
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void initPalya() {
        Timer timer;
        int size;

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);

        size = MAP_SIZE * ROOM_SIZE * WALL_SIZE - 96;
        setPreferredSize(new Dimension(size, size));

        player = new Jatekos(50, 50);

        timer = new Timer(15, this);
        timer.start();
    }

    private void drawObjects(Graphics g) {
        for (int i = 0; i < this.objektumok.size(); i++) {
            Model model = this.objektumok.get(i);
            if (model.isVisible()) {
                g.drawImage(model.getImage(), model.getX(), model.getY(), this);
            }
        }

        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        g.setColor(Color.WHITE);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}
