package net.alexanders.texteditor;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import java.awt.event.*;
import java.beans.*;

public class TextEditor{
    
    private JPanel mainPanel;
    public JEditorPane editorPane1;
    private JToolBar Toolbar;
    private JButton openButton;
    private JButton saveButton;
    private JButton boldButton;
    private JButton underlineButton;
    private JButton italicButton;
    private JButton aboutButton;
    private JButton cutButton;
    private JButton copyButton;
    private JButton pasteButton;
    private JButton shrinkButton;
    private JButton enlargeButton;
    public static TextEditor instance = new TextEditor();

    public TextEditor(){
        ActionListener actionListener = new ButtonListener();
        openButton.addActionListener(actionListener);
        saveButton.addActionListener(actionListener);
        aboutButton.addActionListener(actionListener);
    }



    public static void main(String[] args){
        JFrame frame = new JFrame("TextEditor");
        frame.setContentPane(instance.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1024, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents(){
        editorPane1 = new JEditorPane();
        editorPane1.setEditorKit(new HTMLEditorKit());
        boldButton = new JButton(new StyledEditorKit.BoldAction());
        underlineButton = new JButton(new StyledEditorKit.UnderlineAction());
        italicButton = new JButton(new StyledEditorKit.ItalicAction());
        cutButton = new JButton(new StyledEditorKit.CutAction());
        copyButton = new JButton(new StyledEditorKit.CopyAction());
        pasteButton = new JButton(new StyledEditorKit.PasteAction());
        enlargeButton = new JButton();
        enlargeButton.addActionListener(arg0 -> {
            int size = editorPane1.getFont().getSize();
            size += 1;
            new StyledEditorKit.FontSizeAction("myaction-", size).actionPerformed(arg0);
        });
        shrinkButton = new JButton();
        shrinkButton.addActionListener(arg0 -> {
            int size = editorPane1.getFont().getSize();
            size -= 1;
            new StyledEditorKit.FontSizeAction("myaction-", size).actionPerformed(arg0);
        });
    }
}
