package org.saoud.GUI;
import org.saoud.Data;

import javax.swing.*;
public class MainFrame extends javax.swing.JFrame {
    public MainFrame(Data data) {
        setSize(420,350);
        setResizable(true);

        if (data.getParents() == null)
            add(new LoginPanel( "Make a Parent account !", 2));
        else
            add( new LoginPanel( "Login", 0));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                data.saveData();
                System.exit(0);
            }
        });
        // Created and added the menu bar
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        jMenu1.setText("Menu");

        JMenuItem jMenuItem = new JMenuItem("Open Menu");
        jMenuItem.addActionListener(e -> switchPanel(new MenuPanel()));
        jMenu1.add(jMenuItem);
        jMenuBar1.add(jMenu1);
        jMenuBar1.setVisible(false);
        setJMenuBar(jMenuBar1);
        setVisible(true);
    }

    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        add(panel);
        revalidate();
        repaint();
    }

}
