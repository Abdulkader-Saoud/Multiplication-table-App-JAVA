package org.saoud.GUI;

import org.saoud.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GamePanel extends JPanel {
    private final Session se;
    private int N;
    private int min = 0;
    private int sec = 0;
    private int tmpTimer = 0;
    private final TwoInt ab = new TwoInt();
    private final SessionData sessionData;



    public GamePanel(Session se){
        initComponents();
        this.se = se;
        UIPanel.getFrame().getJMenuBar().setVisible(false);
        N = se.getN() -1 ;
        sessionData = new SessionData();
        sessionData.setStartTime();

        jLabel1.setText("Good Luck " + UIPanel.getData().getCurrentUser().getName());
        Timer timer = new Timer(1000, e -> {
            sec++;
            if (sec == 60){
                min++;
                sec = 0;
            }
            jLabel2.setText(String.format("%02d:%02d", min, sec));
        });
        timer.start();
        gamePart();
    }

    public TwoInt getAb() {
        return ab;
    }

    public JSpinner getjSpinner1() {
        return jSpinner1;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public Session getSe() {
        return se;
    }

    public SessionData getSessionData() {
        return sessionData;
    }
    private void gamePart() {
        jLabel3.setText(N + " Question left ");

        setTQuestion(jLabel4);

        jButton1.addActionListener(e -> {
            QData qData = new QData(ab.getA(), ab.getB(), (int)jSpinner1.getValue() == ab.getA() * ab.getB(),(sec + min * 60) - tmpTimer);
            sessionData.addQ(qData);
            tmpTimer = (sec + min * 60);

            if ((int)jSpinner1.getValue() == ab.getA() * ab.getB()){
                jButton1.setForeground(Color.green);
                sessionData.incCount();

            }else {
                jButton1.setForeground(Color.red);
            }
            if (N == 0){
                UIPanel.getFrame().getJMenuBar().setVisible(true);
                sessionData.setFullTime(sec +min * +60);
                sessionData.setfCount(se.getN() - sessionData.getcCount());
                sessionData.setChildName(UIPanel.getData().getChild().getName());
                new SessionInfoFrame(sessionData);
                se.addSessionData(sessionData);
                UIPanel.getFrame().switchPanel(new MenuPanel());
                return;
            }
            setTQuestion(jLabel4);

            if (N > 1)
                jLabel3.setText(--N + " Question left ");
            else {
                jLabel3.setText("Last Question");
                N--;
            }

        });
    }
    public void setTQuestion(JLabel sLabel){
        Random rand = new Random();
        ab.setA(rand.nextInt(se.getA().getA(), se.getA().getB() + 1));
        ab.setB(rand.nextInt(se.getB().getA(), se.getB().getB()) + 1);

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
