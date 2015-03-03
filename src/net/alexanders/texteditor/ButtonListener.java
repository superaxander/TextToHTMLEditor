package net.alexanders.texteditor;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.html.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("open")){
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.addChoosableFileFilter(new FileFilter(){
                @Override
                public boolean accept(File f){
                    if(f.isFile() && (f.getAbsolutePath().endsWith(".html") || f.getAbsolutePath().endsWith(".htm"))){
                        return true;
                    }
                    return false;
                }

                @Override
                public String getDescription(){
                    return "HTML files";
                }
            });
            int returnvalue = jFileChooser.showOpenDialog(TextEditor.instance.editorPane1);
            if(returnvalue == JFileChooser.APPROVE_OPTION){
                openFile(jFileChooser.getSelectedFile());
            }
        }else if(command.equals("save")){
            JFileChooser jFileChooser = new JFileChooser();
            int returnvalue = jFileChooser.showSaveDialog(TextEditor.instance.editorPane1);
            if(returnvalue == JFileChooser.APPROVE_OPTION){
                saveFile(jFileChooser.getSelectedFile());
            }
        }else if(command.equals("about")){
            About.main(new String[0]);
        }
    }

    private void saveFile(File file){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(TextEditor.instance.editorPane1.getText());
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch(IOException ioexc){
            ioexc.printStackTrace();
        }
    }

    private void openFile(File file){
        final StringBuilder stringBuilder = new StringBuilder();
        try{
            TextEditor.instance.editorPane1.setPage("file:///"+file.getAbsolutePath());
        }catch(IOException ioexc){
            FileIOFail.main(new String[0]);
            ioexc.printStackTrace();
        }
    }
}
