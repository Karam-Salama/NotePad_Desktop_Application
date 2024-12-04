
package notepad_application;

public class Function_Edit {
    
    Gui gui;
    
    public Function_Edit(Gui gui){
        this.gui = gui;
    }
    
    public void makeUndo(){
        gui.um.undo();
    }
    
    public void makeRedo(){
        gui.um.redo();
    }
}
