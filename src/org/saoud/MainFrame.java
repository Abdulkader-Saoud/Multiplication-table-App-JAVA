package org.saoud;

import javax.swing.*;
public class MainFrame extends JFrame {
    JPanel currentPanel;
    public MainFrame(Data data){
        setTitle("Multiplication table App");
        setSize(400,250);
        setResizable(true);

        //currentPanel = new LoginPanel(this,data,"Login",0);
        currentPanel = new GamePanel(this,data); //
        add(currentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
