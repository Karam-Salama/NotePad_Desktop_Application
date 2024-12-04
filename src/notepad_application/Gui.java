package notepad_application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
public class Gui implements ActionListener {
    
    Function_File file = new Function_File(this);
    Function_Format format= new Function_Format(this);
    Function_Color color =  new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);
    KeyHandler keyHanler = new KeyHandler(this);
    
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    
    boolean isWrapped = false;
    
    // for file item 
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem;
    
    // for format item
    JMenuItem wordWraped;
    JMenu menuFontName, menuFontSize;
    JMenuItem fontArialItem, fontTimesNewRomanItem, fontTohamaItem;
    JMenuItem fontSize8, fontSize12, fontSize16, fontSize20, fontSize24, fontSize28;
    
    // for color item
    JMenuItem color1,color2,color3;
    
    // for edit item
    JMenuItem undo, redo;
        
    UndoManager um = new UndoManager();
    
    public Gui() {

        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();
        
        format.selectedFont = "Arial";
        format.createFont(16);
        color.createColor("White");
        format.wrapWord();
        window.setVisible(true);
        window.setIconImage(new ImageIcon("myLogo.jpg").getImage());

    }

    public static void main(String[] args) {
        // TODO code application logic here
        new Gui();
    }

    public void createWindow() {
        window = new JFrame("NotePad Desktop Application");
        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.addKeyListener(keyHanler);
        
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener(){
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                 um.addEdit(e.getEdit());
            }
            
        });
        
        
        
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

        window.setJMenuBar(menuBar);
    }

    public void createFileMenu() {
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        newItem.setActionCommand("New");
        menuFile.add(newItem);

        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        openItem.setActionCommand("Open");
        menuFile.add(openItem);

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        saveItem.setActionCommand("Save");
        menuFile.add(saveItem);

        saveAsItem = new JMenuItem("SaveAs");
        saveAsItem.addActionListener(this);
        saveAsItem.setActionCommand("SaveAs");
        menuFile.add(saveAsItem);

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        exitItem.setActionCommand("Exit");
        menuFile.add(exitItem);
    }
    
    public void createFormatMenu() {
        
        wordWraped = new JMenuItem("Word wrap: off");
        wordWraped.addActionListener(this);
        wordWraped.setActionCommand("wraped");
        menuFormat.add(wordWraped);
        
        // for font name
        menuFontName = new JMenu("Font");
        menuFormat.add(menuFontName);
        
        fontArialItem = new JMenuItem("Arial");
        fontArialItem.addActionListener(this);
        fontArialItem.setActionCommand("Arial");
        menuFontName.add(fontArialItem);
        
        fontTimesNewRomanItem = new JMenuItem("Times New Roman");
        fontTimesNewRomanItem.addActionListener(this);
        fontTimesNewRomanItem.setActionCommand("Times New Roman");
        menuFontName.add(fontTimesNewRomanItem);
        
        fontTohamaItem = new JMenuItem("Tohama");
        fontTohamaItem.addActionListener(this);
        fontTohamaItem.setActionCommand("Tohama");
        menuFontName.add(fontTohamaItem);
        
        
        // for font size
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        
        fontSize8 = new JMenuItem("8 pix");
        fontSize8.addActionListener(this);
        fontSize8.setActionCommand("8 pix");
        menuFontSize.add(fontSize8);
        
        fontSize12 = new JMenuItem("12 pix");
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("12 pix");
        menuFontSize.add(fontSize12);
        
        fontSize16 = new JMenuItem("16 pix");
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("16 pix");
        menuFontSize.add(fontSize16);
        
        fontSize20 = new JMenuItem("20 pix");
        fontSize20.addActionListener(this);
        fontSize20.setActionCommand("20 pix");
        menuFontSize.add(fontSize20);
        
        fontSize24 = new JMenuItem("24 pix");
        fontSize24.addActionListener(this);
        fontSize24.setActionCommand("24 pix");
        menuFontSize.add(fontSize24);
        
        fontSize28 = new JMenuItem("28 pix");
        fontSize28.addActionListener(this);
        fontSize28.setActionCommand("28 pix");
        menuFontSize.add(fontSize28);
        
    }
    
    public void createColorMenu() {
        color1 = new JMenuItem("White");
        color1.addActionListener(this);
        color1.setActionCommand("White");
        menuColor.add(color1);
        
        color2 = new JMenuItem("Black");
        color2.addActionListener(this);
        color2.setActionCommand("Black");
        menuColor.add(color2);
        
        color3 = new JMenuItem("Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Blue");
        menuColor.add(color3);
    
    }
    
    public void createEditMenu() {
        undo = new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        menuEdit.add(undo);
        
        redo = new JMenuItem("Redo");
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        menuEdit.add(redo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break; 
            case "Open":
                file.openFile();
                break;
            case "Save":
                file.saveFile();
                break;
            case "SaveAs":
                file.saveAsFile();
                break;
            case "Exit":
                file.exitFile();
                break;
            case "wraped":
                format.wrapWord();
                break;
            case "Undo":
                edit.makeUndo();
                break;
            case "Redo":
                edit.makeRedo();
                break;
            case "Arial":
                format.setFont("Arial");
                break;
            case "Times New Roman":
                format.setFont("Times New Roman");
                break;
            case "Tohama":
                format.setFont("Tohama");
                break;
            case "8 pix":
                format.createFont(8);
                break;
            case "12 pix":
                format.createFont(12);
                break;
            case "16 pix":
                format.createFont(16);
                break;
            case "20 pix":
                format.createFont(20);
                break;
            case "24 pix":
                format.createFont(24);
                break;
            case "28 pix":
                format.createFont(28);
                break;
            case "White":
                color.createColor("White");
                break;
            case "Black":
                color.createColor("Black");
                break;
            case "Blue":
                color.createColor("Blue");
                break;
            default:
                throw new AssertionError();
        }
    }

}
