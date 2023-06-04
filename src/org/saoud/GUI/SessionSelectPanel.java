package org.saoud.GUI;
import org.saoud.Session;

import javax.swing.*;
import java.awt.*;
import static org.saoud.GUI.UIPanel.getFrame;
import static org.saoud.GUI.UIPanel.getData;

public class SessionSelectPanel extends JPanel {
    // x -> 0 gamePanel
    // x -> 1 Score table
    public SessionSelectPanel(int x) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (Session se : getData().getSessions()) {
            javax.swing.JButton jButton1 = new javax.swing.JButton();
            jButton1.setText(se.getName());
            jButton1.addActionListener(e -> {
                if (x == 0)
                    getFrame().switchPanel(new GamePanel(se));
                else
                    getFrame().switchPanel(new HighScorePanel(se));
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
        getFrame().getContentPane().removeAll();
        getFrame().getContentPane().add(scrollPane);
        getFrame().revalidate();
        getFrame().repaint();
    }


}
