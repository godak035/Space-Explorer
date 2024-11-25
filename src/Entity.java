import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Entity extends Rectangle{

    public int x,y;
    public int speed;
    
        public Entity() {
            super(0, 0, 50, 50); // Default dimensions
        }
    
        public Entity(int x, int y, int width, int height) {
            super(x, y, width, height); // Custom dimensions
        }
    }
    
    

