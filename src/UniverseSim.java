import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;

public class UniverseSim extends Canvas {
    public static final double G = .001;
    public static final double dt = 1.0 / 600.0;
    public static final double steps = 100;
    public static ArrayList<Planet> planets = new ArrayList<>();
    public static Star sun;
    public static Random r = new Random();
    public BufferedImage sImage = loadImage("aster1.png");
    public BufferedImage pImage = loadImage("aster0.png");

    public void paint(Graphics g) {
        sun = new Star(1000000);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1900,1000);
        for(long i=0;i<1E24;i++){
            //System.out.println(i);
            if(i==200) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 1900, 1000);
            }
            sun.update();
            g.drawImage(sImage,940,550,null);

            for(Planet p: planets){
                //g.drawImage(pImage,xposToScreen((int)p.x),yposToScreen((int)p.y),null);
                g.setColor(p.color);
                g.drawRect(xposToScreen((int)p.x),yposToScreen((int)p.y),2,2);
            }
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.setColor(Color.BLACK);
            g.fillRect(0,0,1900,1000);
            */
        }

        /*
        for(long i = 0;i<10000;i++){
            System.out.println(i);
            sun.update();
        }
        System.out.println("heere");
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1900,1000);
        g.drawImage(sImage,950,490,null);
        for(int pos = 0; pos < planets.get(0).xs.size(); pos++){
            //System.out.println("Here");
            for(Planet p: planets){
                g.setColor(p.color);
                g.fillRect(xposToScreen(p.xs.get(pos).intValue()),
                        yposToScreen(p.ys.get(pos).intValue()),5,5);
                //System.out.println("here");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */

    }

    public static void main(String[] args) {

        UniverseSim canvas = new UniverseSim();
        JFrame frame = new JFrame();
        frame.setSize(1900, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Here we add it to the frame
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        simulation();
    }

    public static void simulation() {
    }

    public BufferedImage loadImage(String filePath) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(filePath));
        } catch (IOException e) {
            System.out.print(0);
        }
        return null;
    }

    public static int xposToScreen(int pos){
        return (pos+1900/2);
    }

    public static int yposToScreen(int pos){
        return (pos+1100/2);
    }
}