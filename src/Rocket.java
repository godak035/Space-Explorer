import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Rocket extends Entity{


    KeyHandler keyP;
    int width=87;
    int height =50;

    BufferedImage ship;

    void loadImages() {
        ship = Gui.loadImage("src/sprites/rocket.png");
        System.out.println("Image loaded");

    }
    public Rocket(KeyHandler keyp){

        this.keyP = keyp;
        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

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

        setBounds(x, y, width, height);

    }

    public void paintComponent(Graphics2D g2){

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.CYAN);
        
        
        //g2.fillRect(x, y, width, height);

        g2.drawImage(ship, x, y, width,height, null);



    }

    
}
