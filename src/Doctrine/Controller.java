package Doctrine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private boolean upPressed;
    private boolean rightPressed;
    private boolean downPressed;
    private boolean leftPressed;



    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }


    public boolean isLeftPressed() {
        return leftPressed;
    }


    public boolean isRightPressed() {
        return rightPressed;
    }




    @Override
    public void keyTyped(KeyEvent e) {
     if (e.getKeyChar() == KeyEvent.VK_UP) {
        upPressed = false;
     }
     if (e.getKeyChar() == KeyEvent.VK_DOWN) {
        downPressed = false;
     }
     if (e.getKeyChar() == KeyEvent.VK_LEFT) {
       leftPressed = false;
     }
     if (e.getKeyChar() == KeyEvent.VK_RIGHT) {
       rightPressed = false;
     }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
