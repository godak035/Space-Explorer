/**
 * KeyHandler.java
 * @author Avishan
 * 2024/12/01
 * Handles all of they keyboard inputs
 */

import java.awt.event.*;


public class KeyHandler implements KeyListener{

    //Variables to track the state of each key to see wheater or not it was pressed
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Detects if the key was pressed and sets the coorsponding varibale true
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        

        if (code== KeyEvent.VK_LEFT){
            leftPressed = true;

        }

        if (code== KeyEvent.VK_RIGHT){
            rightPressed = true;
            
        }
        if (code== KeyEvent.VK_UP){
            upPressed = true;
            
        }

        if (code== KeyEvent.VK_DOWN){
            downPressed = true;
            
        }
    }

    /**
     * Detects if the key was released and sets the coorsponding varibale false
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code== KeyEvent.VK_LEFT){
            leftPressed = false;

        }

        if (code== KeyEvent.VK_RIGHT){
            rightPressed = false;
            
        }
        if (code== KeyEvent.VK_UP){
            upPressed = false;
            
        }

        if (code== KeyEvent.VK_DOWN){
            downPressed = false;
            
        }
    } 
}
