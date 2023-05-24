package org.saoud;

import javax.swing.*;

public class MainFrame extends JFrame {
    JPanel currentPanel;
    public MainFrame(Data data){
        setTitle("Multiplication table App");
        setSize(400,250);
        setResizable(true);
        if (data.getParents() == null)
            currentPanel = new LoginPanel(this,data,"Make a Parent account !",2);
        else
            currentPanel = new LoginPanel(this,data,"Login",0);

        add(currentPanel);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                data.saveData();
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public void switchPanel(JPanel panel){
        remove(currentPanel);
        currentPanel = panel;
        add(currentPanel);

        revalidate();
        repaint();

    }
}
