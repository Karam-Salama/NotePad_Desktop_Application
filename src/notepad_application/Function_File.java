
package notepad_application;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Function_File {
    
    Gui gui;
    String fileName, fileDirectory;

    public Function_File(Gui gui) {
        this.gui = gui;
    }
    
    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileDirectory = null;
    }
    
    public void openFile(){
        FileDialog fileDialog = new FileDialog(gui.window,"Open",FileDialog.LOAD);
        fileDialog.setVisible(true);
        
        if(fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            fileDirectory = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }
        System.out.println("File Address and File name: " + fileDirectory + fileName );
        try{
            FileReader fr = new FileReader(fileDirectory + fileName);
            BufferedReader bf = new BufferedReader(fr);
            gui.textArea.setText("");
            String line;
            while((line = bf.readLine()) != null){
                gui.textArea.append(line + "\n");
            }
            bf.close();
        } catch(IOException e) {
            System.out.println("File not Opened");
        }
    }
    
    public void saveFile(){
        if(fileName == null){
            saveAsFile();
        } else {
            try{
                FileWriter fw = new FileWriter(fileDirectory + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch(IOException e) {
                System.out.println("Something Wrong!");
            }
        }
    }
    
    public void saveAsFile(){
        FileDialog fileDialog = new FileDialog(gui.window, "Save" ,FileDialog.SAVE);
        fileDialog.setVisible(true);
        
        if(fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            fileDirectory = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }
        
        try{
            FileWriter fw = new FileWriter(fileDirectory + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch(IOException e) {
            System.out.println("Something Wrong!");
        }
    }
    
    public void exitFile(){
        System.exit(0);
    }
}
