package org.saoud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    public MenuPanel(MainFrame frame, Data data) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400,200));

        JButton statBut = new JButton("Start");
        statBut.setMaximumSize(new Dimension(200, 40));
        statBut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        statBut.setAlignmentX(Component.CENTER_ALIGNMENT);
        statBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel(new GamePanel(frame,data));
            }
        });

        JButton settingBut = new JButton("Settings");
        settingBut.setMaximumSize(new Dimension(180, 40));
        settingBut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        settingBut.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel(new SettingPanel(frame,data));
            }
        });
        JButton logOutBut = new JButton("Logout");
        logOutBut.setMaximumSize(new Dimension(80, 30));
        logOutBut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        logOutBut.setAlignmentX(Component.CENTER_ALIGNMENT);
        logOutBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel(new LoginPanel(frame,data,"Login",0));
            }
        });

        add(Box.createRigidArea(new Dimension(0,20)));
        if (!data.isAdmin()){
            add(statBut);
            add(Box.createRigidArea(new Dimension(0,10)));
        }
        else {
            add(settingBut);
            add(Box.createRigidArea(new Dimension(0,10)));
        }

        add(logOutBut);
    }
}
