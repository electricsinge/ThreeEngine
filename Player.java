import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player {

    int speed = 100;
    int[] location = {-2,-2,-2};
    int[] rotation = {0,0,0};

    int[][][] world = new int[][][]{{{}}};

    int FOV = 2;

    public void connectVerticies(int[] vertex1, int[] vertex2){

        Main.Window.Panel.setLocation(vertex1, vertex2);

    }

    public int[] project2d(int[] vertex){
        int[] screenLocation = {(int)(((double) (vertex[0] * FOV) /(FOV+vertex[2]))*200), (int)(((double) (vertex[1] * FOV) /(FOV+vertex[2]))*200)};
        //Main.Window.Panel.setLocation((int) screenLocation[0], (int) screenLocation[1]);
       // System.out.print("vertex" + Arrays.toString(vertex)+"\n");
     //   System.out.print("screen" + Arrays.toString(screenLocation)+"\n");
        return screenLocation;
    }

    void render(int[][][] world){

        int[][] World = new int[world.length*world[0].length][3];
       // System.out.print("world"+Arrays.deepToString(world)+"\n");

        for(int i=0; i<world.length; i++){
            int[][] objectVerticies = new int[world[i].length][2];
            for(int j=0; j<world[i].length; j++){
                World[i*world[i].length+j] = world[i][j];
                World[i*world[i].length+j][0] -= location[0];
                World[i*world[i].length+j][1] -= location[1];
                World[i*world[i].length+j][2] -= location[2];
                World[i*world[i].length+j][0] += 100;
                World[i*world[i].length+j][1] += 100;
                World[i*world[i].length+j][2] += 100;
                objectVerticies[i*world[i].length+j]=project2d(World[i*world[i].length+j]);
            }

            Main.Window.Panel.lines.clear();
            connectVerticies(objectVerticies[0], objectVerticies[1]);
            connectVerticies(objectVerticies[1], objectVerticies[3]);
            connectVerticies(objectVerticies[0], objectVerticies[2]);
            connectVerticies(objectVerticies[2], objectVerticies[3]);
            connectVerticies(objectVerticies[4], objectVerticies[5]);
            connectVerticies(objectVerticies[5], objectVerticies[7]);
            connectVerticies(objectVerticies[4], objectVerticies[6]);
            connectVerticies(objectVerticies[6], objectVerticies[7]);
            connectVerticies(objectVerticies[0], objectVerticies[4]);
            connectVerticies(objectVerticies[1], objectVerticies[5]);
            connectVerticies(objectVerticies[2], objectVerticies[6]);
            connectVerticies(objectVerticies[3], objectVerticies[7]);
        }
    }

    Player(int[][][] world){
        this.world = world;
        render(world);
        render(world);
    }



}
