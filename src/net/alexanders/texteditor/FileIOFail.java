package net.alexanders.texteditor;

import javax.swing.*;
import java.awt.event.*;

public class FileIOFail extends JDialog{
    private JPanel contentPane;
    private JButton buttonOK;
    private JEditorPane fileCouldnTBeEditorPane;
    private JPanel Containment1;
    private JPanel Containment2;
    private JPanel Containment3;

    public FileIOFail(){
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onOK();
            }
        });
    }

    private void onOK(){
        dispose();
    }

    public static void main(String[] args){
        FileIOFail dialog = new FileIOFail();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
