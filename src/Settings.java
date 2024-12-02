/**
 * Settings.java
 * @author Avishan
 * 2024/12/01
 * Settings screen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JPanel implements ActionListener {
    JFrame frame;
    
    /**
     * Constructor method for the intro screen
     * @param frame
     */
    Settings(JFrame frame) {
        this.frame = frame;

        //Sets up the Setting Screen
        this.setPreferredSize(new Dimension(1024, 768));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Creates the Title text
        JLabel title = new JLabel("Settings");
        title.setFont(new Font("Arial", Font.PLAIN, 80));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        //Creates a radio button group responsible for changing the background color
        ButtonGroup changeColorGroup = new ButtonGroup();

        //Radio button if selected is responsbile for changing the background color to black
        JRadioButton blackButton = new JRadioButton("BLACK");
        blackButton.setForeground(Color.WHITE);
        blackButton.addActionListener(this);
        changeColorGroup.add(blackButton);

        //Radio button if selected is responsbile for changing the background color to blue
        JRadioButton blueButton = new JRadioButton("BLUE");
        blueButton.setForeground(Color.WHITE);
        blueButton.addActionListener(this);
        changeColorGroup.add(blueButton);

        //Radio button if selected is responsbile for changing the background color to purple
        JRadioButton purpleButton = new JRadioButton("PURPLE");
        purpleButton.setForeground(Color.WHITE);
        purpleButton.addActionListener(this);
        changeColorGroup.add(purpleButton);

        //Sets the background color to black
        blackButton.setSelected(true);
        this.setBackground(Color.BLACK); 

        //Create and sets up the the back button responsbile for going back to the Intro screen
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setActionCommand("back");
        backButton.addActionListener(this);

        //Adds all the componenets to the settigns screen using a box layout
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(blackButton);
        this.add(blueButton);
        this.add(purpleButton);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(backButton);
        this.add(Box.createVerticalGlue());
    }

    /**
     * Responsble for detecting if the back button was pressed or which radio button was selected
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        //change the color depending on the selected radio button
        if ("BLACK".equals(command)) {
            this.setBackground(Color.BLACK);
        } 
        
        else if ("BLUE".equals(command)) {
            this.setBackground(Color.BLUE);
        } 
        
        else if ("PURPLE".equals(command)) {
            this.setBackground(new Color(128, 0, 128));
        } 
        
        //If the back button was pressed then it switches to the Intro screen
        else if ("back".equals(command)) {
            System.out.println("Going back to Intro...");
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "Intro");

            //Sets the Intro screens color to the same color as the Settings screen
            Component[] components = frame.getContentPane().getComponents();
            for (Component component : components) {
                if (component instanceof Intro) {
                    component.setBackground(this.getBackground()); 
                    break;
                }
            }
        }
        this.repaint();

    }
}
