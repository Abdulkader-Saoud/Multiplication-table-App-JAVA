package org.saoud.GUI;

import org.saoud.Data;
import org.saoud.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SessionSelectPanel extends JPanel {
    private Data data;
    public SessionSelectPanel(MainFrame frame, Data data) {
        initComponents(data);

    }

    private void initComponents(Data data) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (Session se : data.getSessions()) {
            javax.swing.JButton jButton1 = new javax.swing.JButton();
            jButton1.setText(se.getName());
            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(se.getN());
                }

            });
            jButton1.setAlignmentX(Component.CENTER_ALIGNMENT);

            jButton1.setPreferredSize(new Dimension(200, 35));
            jButton1.setMaximumSize(new Dimension(200, 35));
            add(Box.createVerticalStrut(10));
            add(jButton1);
        }

        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }


}
