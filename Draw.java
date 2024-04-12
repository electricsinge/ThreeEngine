import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Draw extends JPanel implements KeyListener {

    int[] x, y;
    int width, height;

    Draw() {        setFocusable(true); // Make the panel focusable
        requestFocusInWindow(); // Request focus
        addKeyListener(this);}

    void setX(int[] x) {this.x = x;}
    void setY(int[] y) {this.y = y;}
    void setWidth(int width) {this.width = width;}
    void setHeight(int height) {this.height = height;}

    public void setLocation(int[] x, int[] y){
        this.x = x;
        this.y = y;

        addLine(new Line2D.Float(x[0], x[1], y[0], y[1]));
    }

    public ArrayList<Line2D> lines = new ArrayList<>();

    public void addLine(Line2D line) {
        lines.add(line);
        repaint(); // Call repaint to trigger a redraw
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        BasicStroke bs = new BasicStroke(2);
        g2D.setStroke(bs);

        // Redraw all lines stored in the lines list
        for (Line2D line : lines) {
            g2D.draw(line);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println("keyPressed: "+e.getKeyCode()+"\n");
        // Start moving the oval
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Main.playerCamera.location[0] -= Main.playerCamera.speed;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Main.playerCamera.location[0] += Main.playerCamera.speed;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            Main.playerCamera.location[1] -= Main.playerCamera.speed;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Main.playerCamera.location[1] += Main.playerCamera.speed;
        }
        Main.playerCamera.render(Main.playerCamera.world);
        System.out.println("Location: "+ Arrays.toString(Main.playerCamera.location)+"\n");

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
