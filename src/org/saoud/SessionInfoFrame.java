package org.saoud;

import javax.swing.*;
import java.awt.*;

public class SessionInfoFrame extends JFrame {

    private SessionData sData;
    public SessionInfoFrame(SessionData sData){
        setTitle("Session Info");
        setSize(400,350);
        setResizable(true);
        this.sData = sData;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(400,350));

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
            qLabel.setText(q.getTwoInt().getA() + " x " + q.getTwoInt().getB()+ (q.getCorrect() ? " T " : " F ") + " in " + q.getTime() + " sec");
            panel.add(qLabel);
        }

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
