import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Start implements ActionListener, KeyListener{
    JFrame frame;
    DrawingPanel panel; 
    JLabel title;
    JButton button;
    int x,y,vy=5,vx=5;
    int GameState = 0;
    Timer gameLoopTimer;

        public static void main(String[] args) {
    
            SwingUtilities.invokeLater(new Runnable() {
                public void run(){
                  
                    new Start();
            }
        });

        
    }

    Start(){

        x=0;
        y=0;

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Space Explorer");
        frame.addKeyListener(this);


        panel = new DrawingPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(1024, 768));

        if(GameState==0){
            
    
            title = new JLabel("Space Explorer");
            title.setFont(new Font("Arial", Font.PLAIN, 80));
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            button = new JButton("button");
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setPreferredSize(new Dimension(75,30));
            button.setActionCommand("button");
            button.addActionListener(this);
    
            panel.add(Box.createVerticalGlue()); 
            panel.add(title);
            panel.add(Box.createRigidArea(new Dimension(0, 50))); 
            panel.add(button);
            panel.add(Box.createVerticalGlue());
            frame.add(panel, BorderLayout.CENTER);



        }

        else if (GameState == 1){


            JLabel test = new JLabel("We are running now");

            panel.add(test);

            



        }


		frame.pack();
        System.out.println("Does this run");
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
        

    }

    public void updateGame(){
        System.out.println("Gemas is running");
    }

    public void GameLoop(){
        gameLoopTimer = new Timer(100, e->{
            if (GameState==1){
                updateGame();
                panel.repaint();
            }

        });
        gameLoopTimer.start();
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand(); 
        if (command.equals("button")) {
            GameState=1;
            System.out.println("Does this work" + GameState);
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
            GameLoop();

            
            

         
        }


    }

    private class DrawingPanel extends JPanel{
        DrawingPanel(){
            this.setPreferredSize(new Dimension(1024, 726));
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;
            g2.drawRect(x, y, 50, 10);
            g2.drawOval(x+45, y, 10, 10);
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y+=vy;

            System.out.println("Does this work " + y);
            panel.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y-=vy;

            System.out.println("Does this  " + y);
            panel.repaint();
        }
            
            }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}

    
        

    



