package org.saoud;

import org.saoud.GUI.MainFrame;
import org.saoud.GUI.MenuPanel;
import org.saoud.GUI.UIPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class Main {
    public static void main(String[] args) {
        Data data = new Data("Data.dat");
        MainFrame frame=  new MainFrame(data);
        new UIPanel(frame,data);
    }


}