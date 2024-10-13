
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    boolean characterScreen = false, tutorialScreen = false, backKey = false;
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE && tutorialScreen == false){
            characterScreen = true;
        }
        if(code == KeyEvent.VK_T && characterScreen == false){
            tutorialScreen = true;
        }
        if(code == KeyEvent.VK_ESCAPE && characterScreen == true || code == KeyEvent.VK_ESCAPE && tutorialScreen == true){
            backKey = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}