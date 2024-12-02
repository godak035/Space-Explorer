/**
 * Astroid.java
 * @author Avishan
 * 2024/12/01
 * Describes the Rocket's attributes
 */
import java.awt.*;
import java.awt.image.*;

public class Rocket extends Entity{

    KeyHandler keyP;
    int width=87;
    int height =50;
    BufferedImage ship;

    /**
     * Loads the images
     */
    void loadImages() {
        ship = Gui.loadImage("src/sprites/rocket.png");
        System.out.println("Image loaded");

    }

    /**
     * Constructor for Rocket 
     * @param keyp KeyHanler
     */
    public Rocket(KeyHandler keyp){
        this.keyP = keyp;
        setDefaultValues();

    }

    /**
     * Sets the default values
     */
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    /**
     * Updates the postion of the Rocket according to the key input
     */
    public void update(){
        if(keyP.upPressed== true){
            y-=speed;

        }

        if(keyP.downPressed== true){
            y+=speed;
            
        }

        if(keyP.rightPressed== true){
            x+=speed-1;
            
        }

        if(keyP.leftPressed== true){
            x-=speed;
            
        }

        //Updates the rectangle
        setBounds(x, y, width, height);

    }

    /**
     * Handles the drawings associated with the Rocket
     * @param g2
     */
    public void paintComponent(Graphics2D g2){
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw the image of the rocket
        g2.drawImage(ship, x, y, width,height, null);

    }
}
