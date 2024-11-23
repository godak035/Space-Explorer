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

        Gui gui = new Gui();
        frame.add(gui);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gui.startGameThread();

}


}
