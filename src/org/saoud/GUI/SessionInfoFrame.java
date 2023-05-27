package org.saoud.GUI;

import org.saoud.QData;
import org.saoud.SessionData;

import javax.swing.*;
import java.awt.*;

public class SessionInfoFrame extends JFrame {

    public SessionInfoFrame(SessionData sData){
        setTitle("Session Info");
        setSize(400,350);
        setResizable(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(400,350));
        JLabel fTimeLabel1 = new JLabel();
        fTimeLabel1.setPreferredSize(new Dimension(400, 30));
        fTimeLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        fTimeLabel1.setText(String.format(sData.getChildName() + " Started at :",sData.getStartTime()));

        JLabel fTimeLabel = new JLabel();
        fTimeLabel.setPreferredSize(new Dimension(400, 30));
        fTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fTimeLabel.setText(String.format("Finished within : %02d:%02d",sData.getFullTime()/60,sData.getFullTime()%60));

        JLabel tCountLabel = new JLabel();
        tCountLabel.setPreferredSize(new Dimension(400, 30));
        tCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tCountLabel.setForeground(Color.green);
        tCountLabel.setText("True answers count : "+ sData.getcCount());

        JLabel fCountLabel = new JLabel();
        fCountLabel.setPreferredSize(new Dimension(400, 30));
        fCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fCountLabel.setForeground(Color.red);
        fCountLabel.setText("false answers count : "+ sData.getfCount());

        panel.add(fTimeLabel);
        panel.add(tCountLabel);
        panel.add(fCountLabel);

        for (QData q:sData.getqData()){
            JLabel qLabel = new JLabel();
            qLabel.setPreferredSize(new Dimension(400, 30));
            qLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            qLabel.setText(q.getTwoInt().getA() + " x " + q.getTwoInt().getB() + " in " + q.getTime() + " sec");
            if (q.getCorrect())
                qLabel.setForeground(Color.green);
            else
                qLabel.setForeground(Color.red);
            panel.add(qLabel);
        }


        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
