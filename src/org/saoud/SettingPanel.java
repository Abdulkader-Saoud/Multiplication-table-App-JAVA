package org.saoud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingPanel extends JPanel {
    private MainFrame frame;
    private Data data;
    public SettingPanel(MainFrame frame, Data data){
        this.frame = frame;
        this.data = data;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400,200));

        JLabel errorLabel = new JLabel("error");
        errorLabel.setMaximumSize(new Dimension(400, 30));
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorLabel.setForeground(Color.red);
        errorLabel.setVisible(false);


        loginPart();
        abPart(errorLabel,"a");
        abPart(errorLabel,"b");
        nPart(errorLabel);
        add(errorLabel);
        backPart();

    }
    private void loginPart(){
        JButton buttonR = new JButton("Add Child");
        buttonR.setMaximumSize(new Dimension(120, 30));
        buttonR.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonR.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel(new LoginPanel(frame,data,"Register a Child",1));
            }
        });
        add(buttonR);
    }
    private void backPart(){
        JButton buttonR = new JButton("Main Menu");
        buttonR.setMaximumSize(new Dimension(150, 40));
        buttonR.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonR.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel(new MenuPanel(frame,data));
            }
        });
        add(buttonR);
    }
    private void abPart(JLabel errorLabel,String str){
        JPanel inPanel = new JPanel();
        inPanel.setLayout(new BoxLayout(inPanel, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(400,40));
        inPanel.setBackground(Color.gray);
        inPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel aLabel = new JLabel( str+ "-Min:");
        aLabel.setMaximumSize(new Dimension(50, 30));


        JSpinner aField = new JSpinner();
        aField.setMaximumSize(new Dimension(50, 30));
        aField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel bLabel = new JLabel(str+ "-Max :");
        bLabel.setMaximumSize(new Dimension(50, 30));


        JSpinner bField = new JSpinner();
        bField.setMaximumSize(new Dimension(50, 30));
        bField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton sButton = new JButton("Set");
        sButton.setMaximumSize(new Dimension(50, 30));
        sButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    data.setLimited((int)aField.getValue(),(int)bField.getValue(),str);
                    errorLabel.setVisible(false);
                }
                catch (ErrorMan er){
                    errorLabel.setText(er.getMessage());
                    errorLabel.setVisible(true);
                }
            }
        });
        if (str.compareTo("a") == 0){
            aField.setValue(data.getA().getA());
            bField.setValue(data.getA().getB());
        }else {
            aField.setValue(data.getB().getA());
            bField.setValue(data.getB().getB());
        }
        inPanel.add(Box.createRigidArea(new Dimension(10,0)));
        inPanel.add(aLabel);
        inPanel.add(aField);
        inPanel.add(Box.createRigidArea(new Dimension(10,0)));
        inPanel.add(bLabel);
        inPanel.add(bField);
        inPanel.add(Box.createRigidArea(new Dimension(10,0)));

        inPanel.add(sButton);

        add(Box.createRigidArea(new Dimension(0,10)));
        add(inPanel);
    }
    public void nPart(JLabel errorLabel){
        JPanel inPanel = new JPanel();
        inPanel.setLayout(new BoxLayout(inPanel, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(400,40));
        inPanel.setBackground(Color.gray);
        inPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nLabel = new JLabel("N :");
        nLabel.setMaximumSize(new Dimension(20, 30));


        JSpinner nField = new JSpinner();
        nField.setValue(data.getN());
        nField.setMaximumSize(new Dimension(50, 30));
        nField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton sButton = new JButton("Set");
        sButton.setMaximumSize(new Dimension(50, 30));
        sButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    data.setN((int)nField.getValue());
                    errorLabel.setVisible(false);
                }
                catch (ErrorMan er){
                    errorLabel.setText(er.getMessage());
                    errorLabel.setVisible(true);
                }
            }
        });

        inPanel.add(Box.createRigidArea(new Dimension(10,0)));
        inPanel.add(nLabel);
        inPanel.add(nField);
        inPanel.add(Box.createRigidArea(new Dimension(10,0)));

        inPanel.add(sButton);

        add(Box.createRigidArea(new Dimension(0,10)));
        add(inPanel);
    }
}
