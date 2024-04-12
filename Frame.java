import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



public class Frame extends JFrame {

    Draw Panel = new Draw();



    Frame(String name, int height, int width){


        this.add(Panel);

        // JFrame = a GUI window to add components to

        this.setTitle(name); //sets title ofthis
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
        this.setResizable(true); //preventthis from being resized
        this.setSize(width,height); //sets the x-dimension, and y-dimension ofthis
        this.setVisible(true); //makethis visible

//        ImageIcon image = new ImageIcon("logo.png"); //create an ImageIcon
        //       this.setIconImage(image.getImage()); //change icon ofthis
        //this.getContentPane().setBackground(new Color(0x123456)); //change color of background



    }


}
