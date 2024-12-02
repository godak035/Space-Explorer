/**
 * Intro.java
 * @author Avishan
 * 2024/12/01
 * Intro screen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Intro extends JPanel implements ActionListener {
    JFrame frame;
    JPanel gui;
    BufferedImage ship;

    /**
     * Constructor method for the intro screen
     * @param frame
     */
    Intro(JFrame frame) {
        //Sets up the intro screen
        this.frame = frame;
        this.setPreferredSize(new Dimension(1024, 768));
        this.setBackground(Color.BLACK);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Creates the Title text
        JLabel title = new JLabel("Space Explorer");
        title.setFont(new Font("Arial", Font.PLAIN, 80));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Creates the start button responisble for switching to the GUI screen
        JButton start = new JButton("Start Game");
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setActionCommand("start");
        start.addActionListener(this);
        start.setPreferredSize(new Dimension(150, 50));

        //Creates the settings button responsbile for switching to the Settings Screen
        JButton settingsButton = new JButton("Settings");
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setActionCommand("settings");
        settingsButton.addActionListener(this);

        //Uses a box layout to organize the components on the Intro screen
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(start);
        this.add(settingsButton);
        this.add(Box.createVerticalGlue());

    }

    /**
     * Checks to see which button was clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        //If the start button was pressed then it would switch to the GUI screen
        if ("start".equals(command)) {

            //Allows to switch from the Intro screen to the GUI Screen
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "Gui");

            //Itterates through all the components to check for the GUI panel
            Component[] components = frame.getContentPane().getComponents();
            for (Component component : components) {
                //If it is the GUI panel then changes the focus to GUI screen and starts the game thread
                if (component instanceof Gui) {
                    ((Gui) component).setBackground(this.getBackground()); 
                    ((Gui) component).startGameThread();
                    ((Gui) component).requestFocusInWindow();

                }
            }
        }

        //If the Settings button was pressed then it would switch to the settigns screen
        else if ("settings".equals(command)) {
            //Allows to switch from the Intro screen to the Settings screen
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "Settings");
        }
    }
}
