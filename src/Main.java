import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class Main {

    


    public static void main(String[] args) {
    
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Space Explorer");
        CardLayout cardLayout = new CardLayout();
        frame.setLayout(cardLayout);

        Intro intro = new Intro(frame);
        Gui gui = new Gui();
        
        frame.getContentPane().add(intro, "Intro");
        frame.getContentPane().add(gui, "Gui");

        cardLayout.show(frame.getContentPane(), "Intro");

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gui.startGameThread();

}


}
