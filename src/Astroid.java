/**
 * Astroid.java
 * @author Avishan
 * 2024/12/01
 * Describes the Astroid's attributes and behaviours with the player
 */

import java.awt.*;
import java.awt.image.*;

public class Astroid extends Entity{

    Gui gp;
    static BufferedImage rock;
    
    /**
     * Loads the images
     */
    static void loadImage() {
        rock = Gui.loadImage("src/sprites/astroid.png");

    }

    /**
     * Constructor for Astroids
     * @param gp The panel which the main game is ran on
     */
    public Astroid(Gui gp){
        this.gp = gp;
        setDefaultValues();

    }

    /**
     * Sets the defult values of the Astroid
     */
    public void setDefaultValues(){
        x = 1000;
        y = (int) (Math.random() * gp.height);
        speed = 4;

    }

    /**
     * Updates the position of the rectangle and the astroid
     */
    public void update(){
        x-=speed;
        setBounds(x, y, 50, 50);

    }

    /**
     * Draws the Astroid
     * @param g2
     */
    public void draw(Graphics2D g2){
        g2.drawImage(rock, x, y, width, height, null);

    }
}
