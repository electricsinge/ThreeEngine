import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main{

    public static Frame Window = new Frame("Window", 200, 200);


    static void drawPixel(Frame frame, int x, int y) {

        Graphics2D g2D = (Graphics2D) frame.getGraphics();
        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(20));
        System.out.println("Draw Pixel");
        g2D.drawLine(x, y, x, y);

    }

    static int[][] cubeVerticies = new int[][]{{0,100,0},{100,100,0},{0,0,0},{100,0,0}, {0,100,100}, {100,100,100}, {0,0,100}, {100,0,100}};
    static Object Cube = new Object(cubeVerticies);
    public static Object[] worldObjects = {Cube};

    static int[][][] worldPoints = new int[1][8][3];

    public static Player playerCamera = new Player(worldPoints);

    public static void createWorld(Object[] objects){
        System.out.println(objects.length + "worldPoints");
        for(int i = 0; i<objects.length; i++){
            worldPoints[i] = objects[i].verticies;
        }
    }

    public int[][][] getWorld(){
        return worldPoints;
    }

    public static void main(String[] args){

        createWorld(worldObjects);

        playerCamera.world = worldPoints;

        playerCamera.render(playerCamera.world);


        // System.out.println(Arrays.deepToString(worldPoints));

        boolean[][][] booleanWorld = new boolean[200][200][200];


       /* for(int n = 0; n < worldPoints.length; n++) {
            for (int i = 0; i < 8; i++) {
                booleanWorld[worldPoints[n][i][0]][worldPoints[n][i][1]][worldPoints[n][i][2]] = true;
            }
        }*/

        //     Window.getContentPane().add(new DrawingComponent());

        //  System.out.println(Arrays.deepToString(booleanWorld));



    }



}
