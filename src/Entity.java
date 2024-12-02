/**
 * Entity.java
 * @author Avishan
 * 2024/12/01
 * Describes all the basic behaviors an Entity would need
 */

import java.awt.*;

public class Entity extends Rectangle{

    //Basic Attributes of an Entity
    public int x,y;
    public int speed;
    
    /**
     * Constructor for basic Entities
     */
        public Entity() {
            super(0, 0, 50, 50); 
        }

    /**
     * Constructor for basic Entities 
     * @param x x position on the map
     * @param y y postion on the map
     * @param width the width of an object
     * @param height the height of an object
     */
        public Entity(int x, int y, int width, int height) {
            super(x, y, width, height); 
        }
    }
