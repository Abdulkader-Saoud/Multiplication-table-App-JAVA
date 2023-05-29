package org.saoud.GUI;
import org.saoud.Data;

import javax.swing.*;
public class MainFrame extends javax.swing.JFrame {
    public MainFrame(Data data) {
        setSize(420,350);
        setResizable(true);

        if (data.getParents() == null)
            add(new LoginPanel(this, data, "Make a Parent account !", 2));
        else
            add( new LoginPanel(this, data, "Login", 0));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                data.saveData();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        add(panel);
        revalidate();
        repaint();
    }

}
