import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Astroid extends Entity{

    Gui gp;



    public Astroid(Gui gp){
        this.gp = gp;

        setDefaultValues();

    }

    public void setDefaultValues(){
        x = 1000;
        y = (int) (Math.random() * gp.height);
        speed = 3;
    }



    public void update(){
      
        x-=speed;
 
    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.RED);

        g2.fillRect(x, y, 50, 50);

    }

    
}

    
