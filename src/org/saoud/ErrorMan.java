package org.saoud;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ErrorMan extends IOException {
    public ErrorMan(String title,String text){
        JFrame frame = new JFrame();
        frame.setTitle("Session Info");
        frame.setSize(200,75);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(200,75));
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(180, 30));
        label.setText(title);
        JLabel label2 = new JLabel();
        label2.setPreferredSize(new Dimension(180, 30));
        label2.setText(title);
        label2.setForeground(Color.red);
        panel.add(label);
        panel.add(label2);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    public ErrorMan(String text){
        super(text);
    }
}
