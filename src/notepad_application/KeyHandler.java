
package notepad_application;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter{
    Gui gui;
    
    public KeyHandler(Gui gui){
        this.gui = gui;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            gui.file.saveFile();
        }
        if(e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            gui.file.saveAsFile();
        }
        if(e.isAltDown()&& e.getKeyCode() == KeyEvent.VK_F){
            gui.menuFile.doClick();
        }
    }
    
}
