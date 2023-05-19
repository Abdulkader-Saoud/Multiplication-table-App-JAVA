package org.saoud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    public LoginPanel(MainFrame frame,Data data,String title,int x){
        setLayout(null);
        setBounds(0,0,400,200);
        JLabel tileLabel= new JLabel(title);
        tileLabel.setBounds(10,10,100,20);

        JLabel userLabel= new JLabel("Username :");
        userLabel.setBounds(10,40,100,30);
        JTextField userField = new JTextField();
        userField.setBounds(110,40,250,30);

        JLabel passLabel= new JLabel("Password :");
        passLabel.setBounds(10,80,100,30);
        JTextField passField = new JTextField();
        passField.setBounds(110,80,250,30);

        JLabel errorLabel= new JLabel("Error");
        errorLabel.setBounds(10,150,300,30);
        errorLabel.setForeground(Color.red);
        errorLabel.setVisible(false);


        JButton button = new JButton(x == 0 ? "Login" : "Register");
        button.setBounds(20,120,350,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (x == 0)
                        data.checkUserAuth(userField.getText(),passField.getText());
                    else
                        data.addUser(userField.getText(),passField.getText());
                    frame.switchPanel(new MenuPanel(frame,data));
                }
                catch (ErrorMan er){
                    errorLabel.setText(er.getMessage());
                    errorLabel.setVisible(true);
                }
            }
        });


        add(tileLabel);
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(errorLabel);
        add(button);
    }
}
