/**
 * Gui.java
 * @author Avishan
 * 2024/12/01
 * Gui Screen
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.*;
import javax.swing.*;

public class Gui extends JPanel implements Runnable {
    
    
    public final int width = 1026;
    public final int height = 726;

    int FPS = 60;
    KeyHandler keyP = new KeyHandler();
    Thread gameThread;
    Rocket rocket  = new Rocket(keyP);
    Timer astroidTimer;
    ArrayList <Astroid> astroids = new ArrayList<Astroid>();
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    /**
     * Used to load images
     * @param filename the name of the image you want to load
     * @return the image
     */
    static BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "An image failed to load: " + filename, "Error", JOptionPane.ERROR_MESSAGE);
        }
        //DEBUG
        //if (img == null) System.out.println("null");
        //else System.out.printf("w=%d, h=%d%n",img.getWidth(), img.getHeight());
        return img;
    }

    /**
     * Constructor method for the GUI screen
     */
    public Gui(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyP);
        this.setFocusable(true);
        rocket.loadImages();
        Astroid.loadImage();

        //Every time the timer goes off a new astroid is created
        astroidTimer = new Timer(250, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spawnAstroid();
                

            }
        });
    }

    /**
     * Checks to see if any of the astroids collided with the rocket
     */
    public void checkCollision(){
        for (Astroid a : astroids) {
          if (a.intersects(rocket)){
           a.speed=a.speed*-1;
           gameThread = null; 
           JOptionPane.showMessageDialog(this, "Game Over!");
           System.exit(0);            
            }
            
        }

        //Keeps the rocket inside the screen
        if (rocket.x <= 0) {
            rocket.x = 0;
        }
        if (rocket.x >= this.width-rocket.width) {
            rocket.x = this.width-rocket.width;
        }
        if (rocket.y <= 0) {
            rocket.y = 0;
        }
        if (rocket.y >= (this.height-rocket.height)) {
            rocket.y = this.height-rocket.height;
        }
    }


    /**
     * Creates and starts the thread responsible for the game as well as starts the astroid timer
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        astroidTimer.start();

    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount =0;
    
        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer+= (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
                
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount=0;
                timer =0;
            }
            
        }

    }

    /**
     * Updates the position of the rocket
     */
    public void update(){
      rocket.update();
      //To ensure that the rocket stays inbounds
      checkCollision();
      for (Astroid astroid : astroids) {
        astroid.update();
      }
      astroids.removeIf(astroid -> astroid.x + astroid.width < 0);

    }

    //Creates a new astroid
    public void spawnAstroid() {
        // Create a new asteroid at a random position
        Astroid newAstroid = new Astroid(this);
        astroids.add(newAstroid);
    }

    //Draws Everything
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Draws the rocket
        rocket.paintComponent(g2);
        //Draws each Astroid
        for (Astroid astroid : astroids) {
            astroid.draw(g2);
        }
        g2.dispose();
    }
}
