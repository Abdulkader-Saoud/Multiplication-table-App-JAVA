package org.saoud.GUI;

import org.saoud.*;
import org.saoud.GUI.MainFrame;
import org.saoud.GUI.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GamePanel extends JPanel {
    private Data data;
    private MainFrame frame;
    private int N;
    private int min = 0;
    private int sec = 0;
    private int tmpTimer = 0;
    private TwoInt ab = new TwoInt();
    private SessionData session;
    public GamePanel(MainFrame frame, Data data){
        initComponents();
        this.data = data;
        this.frame = frame;

        //N = data.getN() -1;
        session = data.getChild().newSession();
        jLabel1.setText("Good Luck " + data.getCurrentUser().getName());
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sec++;
                if (sec == 60)
                    min++;
                jLabel2.setText(String.format("%02d:%02d", min, sec));
            }
        });
        timer.start();
        gamePart();
    }
    private void gamePart() {
        jLabel3.setText(N + " Question left ");

        setTQuestion(jLabel4);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QData qData = new QData(ab.getA(), ab.getB(), (int)jSpinner1.getValue() == ab.getA() * ab.getB(),(sec + min * 60) - tmpTimer);
                session.addQ(qData);
                tmpTimer = (sec + min * 60);

                if ((int)jSpinner1.getValue() == ab.getA() * ab.getB()){
                    jButton1.setForeground(Color.green);
                    session.incCount();

                }else {
                    jButton1.setForeground(Color.red);
                }
                if (N == 0){
                    session.setFullTime(sec +min * +60);
                    //session.setfCount(data.getN() - session.getcCount());
                    new SessionInfoFrame(session);
                    frame.switchPanel(new MenuPanel(frame,data));
                    return;
                }
                setTQuestion(jLabel4);

                if (N > 1)
                    jLabel3.setText(--N + " Question left ");
                else {
                    jLabel3.setText("Last Question");
                    N--;
                }

            }
        });
    }
    private void setTQuestion(JLabel sLabel){
        Random rand = new Random();
        //ab.setA(rand.nextInt(data.getA().getA(), data.getA().getB()));
        //ab.setB(rand.nextInt(data.getA().getA(), data.getA().getB()));

        sLabel.setText(ab.getA() + " x " + ab.getB());
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("3 Question left");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");

        jButton1.setText("Set");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSpinner1)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(81, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(43, Short.MAX_VALUE))
        );
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
}
