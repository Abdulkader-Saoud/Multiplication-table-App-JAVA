package org.saoud;

import org.saoud.GUI.MainFrame;
import org.saoud.GUI.MenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class Main {
    public static void main(String[] args) {
        Data data = new Data();
        MainFrame frame=  new MainFrame(data);
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        jMenu1.setText("Menu");

        JMenuItem jMenuItem = new JMenuItem("Open Menu");
        jMenuItem.addActionListener(e -> frame.switchPanel(new MenuPanel(frame, data)));
        jMenu1.add(jMenuItem);
        jMenuBar1.add(jMenu1);
        jMenuBar1.setVisible(false);
        frame.setJMenuBar(jMenuBar1);
    }


}