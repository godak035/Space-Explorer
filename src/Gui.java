import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Gui extends JPanel implements Runnable {
    
    
    final int width = 1026;
    final int height = 726;

    int FPS = 60;

    KeyHandler keyP = new KeyHandler();
    Thread gameThread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public Gui(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyP);
        this.setFocusable(true);
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

        if(keyP.upPressed== true){
            playerY-=playerSpeed;

        }

        if(keyP.downPressed== true){
            playerY+=playerSpeed;
            
        }

        if(keyP.rightPressed== true){
            playerX+=playerSpeed;
            
        }

        if(keyP.leftPressed== true){
            playerX-=playerSpeed;
            
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.CYAN);

        g2.fillRect(playerX, playerY, 50, 50);

        g2.dispose();
    }
}
