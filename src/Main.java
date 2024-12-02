/**
 * Main.java
 * @author Avishan
 * 2024/12/01
 * Running Space Explorer game and setting up the frame and intitilizing all the panels
 */
import java.awt.*;
import javax.swing.*;

public class Main {

    /**
     * Main Method which is used to run the actual game
     */
    public static void main(String[] args) {
    
        //Creating and setting up the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Space Explorer");

        //Creates the cardlayout which is used to switch between panels
        CardLayout cardLayout = new CardLayout();
        frame.setLayout(cardLayout);

        //Creates and intitalizes all the panels
        Intro intro = new Intro(frame);
        Settings settings = new Settings(frame);
        Gui gui = new Gui();
        
        //Adds the panels to frame as well as creates a name for the cardlayout to manage
        frame.getContentPane().add(intro, "Intro");
        frame.getContentPane().add(settings, "Settings");
        frame.getContentPane().add(gui, "Gui");

        //Displays the Intro screen 
        cardLayout.show(frame.getContentPane(), "Intro");

        //Sets the frame in the midle of screen and visible
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
