package org.saoud.GUI;

import org.saoud.Data;
import org.saoud.Session;
import org.saoud.SessionData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScorePanel extends JPanel {
    public HighScorePanel(MainFrame frame, Data data,Session session) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (SessionData se : session.getSessionData()) {
            javax.swing.JButton jButton1 = new javax.swing.JButton();
            // here jButton1.setText(se.getName());
            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (x == 0)
                        frame.switchPanel(new GamePanel(frame,data,se));
                }

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
