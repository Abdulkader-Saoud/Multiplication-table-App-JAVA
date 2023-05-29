package org.saoud.GUI;

import org.saoud.Data;
import org.saoud.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SessionSelectPanel extends JPanel {
    // x -> 0 gamePanel
    // x -> 1 Score table
    public SessionSelectPanel(MainFrame frame, Data data ,int x) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (Session se : data.getSessions()) {
            javax.swing.JButton jButton1 = new javax.swing.JButton();
            jButton1.setText(se.getName());
            jButton1.addActionListener(e -> {
                if (x == 0)
                    frame.switchPanel(new GamePanel(frame,data,se));
                else
                    frame.switchPanel(new HighScorePanel(data,se));
            });
            jButton1.setAlignmentX(Component.CENTER_ALIGNMENT);

            jButton1.setPreferredSize(new Dimension(200, 35));
            jButton1.setMaximumSize(new Dimension(200, 35));
            add(Box.createVerticalStrut(10));
            add(jButton1);
        }
        setPreferredSize(new Dimension(getPreferredSize().width, getPreferredSize().height));
        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(scrollPane);
        frame.revalidate();
        frame.repaint();
    }


}
