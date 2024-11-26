import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Intro extends JPanel implements ActionListener {
    JFrame frame;
    BufferedImage ship;

    Intro(JFrame frame) {
        System.out.println("Intro panel initialized.");
        this.frame = frame;


        this.setPreferredSize(new Dimension(1024, 768));
        this.setBackground(Color.BLACK);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add title
        JLabel title = new JLabel("Space Explorer");
        title.setFont(new Font("Arial", Font.PLAIN, 80));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add button
        JButton button = new JButton("Start Game");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("start");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(150, 50));

        // Add components
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(button);
        this.add(Box.createVerticalGlue());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("start".equals(command)) {
            System.out.println("Switching to Gui...");
            // Access the CardLayout to switch screens
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "Gui");
            
            Component[] components = frame.getContentPane().getComponents();
            for (Component component : components) {
                if (component instanceof Gui) {
                    ((Gui) component).requestFocusInWindow();
                }
            }
            
        }
    }
}
