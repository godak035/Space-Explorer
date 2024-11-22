import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class RocketShip implements KeyListener{
    JFrame frame;
    DrawingPanel panel;
    static int x=100;
    static int y=0;
    static int vy=5;
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
              
                new RocketShip();
        }
    });
    }

    RocketShip(){
        frame = new JFrame();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Space Explorer");
        panel = new DrawingPanel();
        panel.setBackground(Color.GREEN);
        frame.addKeyListener(this);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

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
