package net.alexanders.texteditor;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class About extends JDialog{
    private JPanel contentPane;
    private JButton buttonOK;
    private JEditorPane textToHTMLEditorEditorPane;

    public About(){
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onOK();
            }
        });
    }

    private void onOK(){
        this.dispose();
    }

    public static void main(String[] args){
        About dialog = new About();
        dialog.pack();
        dialog.setSize(1024, 512);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void createUIComponents(){
        textToHTMLEditorEditorPane = new JEditorPane();
        textToHTMLEditorEditorPane.setContentType("text/html");
        textToHTMLEditorEditorPane.setEditorKit(new HTMLEditorKit());
        textToHTMLEditorEditorPane.setEditable(false);
        textToHTMLEditorEditorPane.setEnabled(true);
        try{
            textToHTMLEditorEditorPane.setPage(About.class.getResource("about.html"));
        }catch(IOException ioexc){
            System.out.println(ioexc.getMessage());
        }
        textToHTMLEditorEditorPane.addHyperlinkListener(hyperlinklistener -> {
            if (hyperlinklistener.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(hyperlinklistener.getURL().toURI());
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });;
    }
}
