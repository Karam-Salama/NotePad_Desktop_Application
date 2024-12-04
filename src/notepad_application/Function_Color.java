
package notepad_application;

import java.awt.Color;

public class Function_Color {
    
    Gui gui;
    
    public Function_Color(Gui gui){
        this.gui = gui;
    }
    
    public void createColor(String color){
        switch (color) {
            case "White":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.GREEN);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(Color.BLUE);
                gui.textArea.setBackground(Color.BLUE);
                gui.textArea.setForeground(Color.WHITE);
                break;
            default:
                throw new AssertionError();
        }
    }
}
