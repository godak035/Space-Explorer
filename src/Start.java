import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Start implements ActionListener{
    JFrame frame;
    DrawingPanel panel; 
    JLabel title;
    JButton button;
    int GameState = 0;

        public static void main(String[] args) {
    
            SwingUtilities.invokeLater(new Runnable() {
                public void run(){
                  
                    new Start();
            }
        });

        
    }

    Start(){


        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Space Explorer");

        if(GameState==0){
            panel = new DrawingPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setPreferredSize(new Dimension(1024, 768));
    
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

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand(); 
        if (command.equals("button")) {
            GameState=1;
            System.out.println("Does this work" + GameState);
            panel.removeAll();
            panel.repaint();
            
            

         
        }


    }

    private class DrawingPanel extends JPanel{

        DrawingPanel(){
            this.setPreferredSize(new Dimension(1026, 726));
         //   this.setBackground(Color.BLACK);

        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);


        }
    
        
    } 
    
}


