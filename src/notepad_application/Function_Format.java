
package notepad_application;

import java.awt.Font;

public class Function_Format {
    
    Gui gui;
    Font arial, tohama, timesNewRoman;
    String selectedFont;
    
    public Function_Format(Gui gui){
        this.gui = gui;
    }
    
    public void wrapWord(){
        if(gui.isWrapped == false){
            gui.isWrapped = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.wordWraped.setText("Word wrap: on");
        }else if(gui.isWrapped == true){
            gui.isWrapped = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.wordWraped.setText("Word wrap: off");
        }
    }
    
    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        tohama = new Font("Tohama", Font.PLAIN , fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize); 
        
        setFont(selectedFont);
    }
    
    public void setFont(String font){
        selectedFont = font;
        
        switch (selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Tohama":
                gui.textArea.setFont(tohama);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
            default:
                throw new AssertionError();
        }
    }
}
