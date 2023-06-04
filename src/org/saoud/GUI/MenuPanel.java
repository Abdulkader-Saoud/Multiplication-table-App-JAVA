package org.saoud.GUI;
import javax.swing.*;

import static org.saoud.GUI.UIPanel.getFrame;
import static org.saoud.GUI.UIPanel.getData;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        getFrame().getContentPane().removeAll();
        initComponents();
        startBut.addActionListener(e -> new SessionSelectPanel(0));
        settBut.addActionListener(e -> getFrame().switchPanel(new SettingPanel()));
        logBut.addActionListener(e -> {
            getFrame().getJMenuBar().setVisible(false);
            getFrame().switchPanel(new LoginPanel("Login",0));
        });
        socresBut.addActionListener(e -> new SessionSelectPanel(1));

        if (getData().isAdmin())
            startBut.setVisible(false);
        else
            settBut.setVisible(false);

        getFrame().add(this);
        getFrame().revalidate();
        getFrame().repaint();
    }
    private void initComponents() {

        startBut = new javax.swing.JButton();
        settBut = new javax.swing.JButton();
        socresBut = new javax.swing.JButton();
        logBut = new javax.swing.JButton();

        startBut.setText("Start");


        settBut.setText("Setting");


        socresBut.setText("Scores");


        logBut.setText("Logout");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(startBut, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(settBut, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(socresBut, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(logBut, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(startBut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(settBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(socresBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(58, Short.MAX_VALUE))
        );
    }
    private javax.swing.JButton startBut;
    private javax.swing.JButton settBut;
    private javax.swing.JButton socresBut;
    private javax.swing.JButton logBut;
}
