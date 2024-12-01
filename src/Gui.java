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


    public Gui(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyP);
        this.setFocusable(true);
        rocket.loadImages();
        Astroid.loadImage();


        astroidTimer = new Timer(250, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spawnAstroid();
                

            }
        });
        astroidTimer.start();
    }

    public void checkCollision(){
        for (Astroid a : astroids) {
          if (a.intersects(rocket)){
           a.speed=a.speed*-1;
           gameThread = null; // Stop the game thread
           JOptionPane.showMessageDialog(this, "Game Over!");
           System.exit(0);            
            }
            
        }

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
            System.out.println(rocket.y);
        }
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
      checkCollision();

      for (Astroid astroid : astroids) {
        astroid.update();
        

        
      }
      astroids.removeIf(astroid -> astroid.x + astroid.width < 0);


      
      

    }

    public void spawnAstroid() {
        // Create a new asteroid at a random position
        Astroid newAstroid = new Astroid(this);
        astroids.add(newAstroid);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        rocket.paintComponent(g2);
        
        for (Astroid astroid : astroids) {
            astroid.draw(g2);
        }


        g2.dispose();
    }
}
