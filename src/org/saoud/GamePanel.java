package org.saoud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GamePanel extends JPanel {
    private  Data data;
    private MainFrame frame;
    private int N;
    private int min = 0;
    private int sec = 0;
    private int tmpTimer = 0;
    private TwoInt ab = new TwoInt();
    private SessionData session;
    public GamePanel(MainFrame frame, Data data){
        this.data = data;
        this.frame = frame;
        N = data.getN() -1;
        session = data.getChild().newSession();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(500,200));

        add(Box.createRigidArea(new Dimension(0,10)));
        timerPart();
        add(Box.createRigidArea(new Dimension(0,10)));
        gamePart();
    }
    private void timerPart(){
        JPanel inPanel = new JPanel();
        inPanel.setLayout(new BoxLayout(inPanel, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(400,30));
        inPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Good Luck " + data.getCurrentUser().getName());
        titleLabel.setPreferredSize(new Dimension(150, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.green);

        JLabel qLabel = new JLabel();
        qLabel.setPreferredSize(new Dimension(200, 30));
        qLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        qLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        qLabel.setText("00:00");


        inPanel.add(titleLabel);
        inPanel.add(Box.createRigidArea(new Dimension(10,0)));
        inPanel.add(qLabel);
        add(inPanel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sec++;
                if (sec == 60)
                    min++;
                qLabel.setText(String.format("%02d:%02d", min, sec));
            }
        });
        timer.start();

    }
    private void gamePart() {

        JLabel qLabel = new JLabel();

        qLabel.setPreferredSize(new Dimension(200, 30));
        qLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        qLabel.setText(N + " Question left ");

        JLabel sLabel = new JLabel();

        sLabel.setPreferredSize(new Dimension(200, 50));
        sLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        setTQuestion(sLabel);

        JSpinner ansField = new JSpinner();
        ansField.setMaximumSize(new Dimension(75, 30));
        ansField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton setButton = new JButton("Set");
        setButton.setMaximumSize(new Dimension(60,30));
        setButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QData qData = new QData(ab.getA(), ab.getB(), (int)ansField.getValue() == ab.getA() * ab.getB(),(sec + min * 60) - tmpTimer);
                session.addQ(qData);
                tmpTimer = (sec + min * 60);

                if ((int)ansField.getValue() == ab.getA() * ab.getB()){
                    setButton.setForeground(Color.green);
                    session.incCount();

                }else {
                    setButton.setForeground(Color.red);
                }
                if (N == 0){
                    session.setFullTime(sec +min * +60);
                    session.setfCount(data.getN() - session.getcCount());
                    new SessionInfoFrame(session);
                    frame.switchPanel(new MenuPanel(frame,data));
                    return;
                }
                setTQuestion(sLabel);

                if (N > 1)
                    qLabel.setText(--N + " Question left ");
                else {
                    qLabel.setText("Last Question");
                    N--;
                }

            }
        });
        add(qLabel);
        add(Box.createRigidArea(new Dimension(0,3)));
        add(sLabel);
        add(Box.createRigidArea(new Dimension(0,3)));
        add(ansField);
        add(Box.createRigidArea(new Dimension(0,3)));
        add(setButton);
    }
    private void setTQuestion(JLabel sLabel){
        Random rand = new Random();
        ab.setA(rand.nextInt(data.getA().getA(), data.getA().getB()));
        ab.setB(rand.nextInt(data.getA().getA(), data.getA().getB()));

        sLabel.setText(ab.getA() + " x " + ab.getB());
    }
}
