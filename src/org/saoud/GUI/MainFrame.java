package org.saoud.GUI;
import org.saoud.Data;

import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame {
    JPanel currentPanel;

    public MainFrame(Data data) {
        setVisible(true);
        setSize(420,350);
        setResizable(true);

        if (data.getParents() == null)
            currentPanel = new LoginPanel(this, data, "Make a Parent account !", 2);
        else
            currentPanel = new LoginPanel(this, data, "Login", 0);

        add(currentPanel);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                data.saveData();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public void switchPanel(JPanel panel) {
        remove(currentPanel);
        currentPanel = panel;
        add(currentPanel);

        revalidate();
        repaint();

    }

}
