import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Rocket extends Entity{

    Gui gp;
    KeyHandler keyP;
    int width=50;
    int height =50;

    BufferedImage ship, rock;
    public Rocket(Gui gp, KeyHandler keyp){
        this.gp = gp;
        this.keyP = keyp;
        setDefaultValues();
        
        try {
			ship = ImageIO.read(this.getClass().getResource("sprites/ship.png"));
			rock = ImageIO.read(this.getClass().getResource("sprites/rock.png"));
            System.out.println("Loaded images 1");
		} catch (Exception e) {
			System.out.println("Failed to load image.");
		}
        System.out.println("loaded images 2");

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

        setBounds(x, y, 50, 50);

    }

    public void draw(Graphics2D g2){

        
        g2.setColor(Color.CYAN);

        g2.fillRect(x, y, width, height);
        

    }

    
}
