import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;
import javax.swing.*;

public class Gui extends JPanel implements Runnable {
    
    
    final int width = 1026;
    final int height = 726;

    int FPS = 60;

    KeyHandler keyP = new KeyHandler();
    Thread gameThread;
    Rocket rocket  = new Rocket(this, keyP);
    Astroid astroid = new Astroid(this);
    Timer astroidTimer;
    ArrayList <Astroid> astroids = new ArrayList<>();
    

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public Gui(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyP);
        this.setFocusable(true);

        astroidTimer = new Timer(1050, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spawnAstroid();

            }
        });
        astroidTimer.start();
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
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
            
            
            

            //Update
            

            //Draw
            
            
        }

    }

    public void update(){

      rocket.update();

      for (Astroid astroid : astroids) {
        astroid.update();
        
      }

      
      

    }

    public void spawnAstroid() {
        // Create a new asteroid at a random position
        Astroid newAstroid = new Astroid(this);
        astroids.add(newAstroid);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        rocket.draw(g2);
        
        astroid.draw(g2);
        for (Astroid astroid : astroids) {
            astroid.draw(g2);
        }


        g2.dispose();
    }
}
