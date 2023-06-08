package org.saoud;
import org.saoud.GUI.MainFrame;
import org.saoud.GUI.UIPanel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public  class Main {
    public static void main(String[] args) {
        Data data;
        try{
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream("Data.txt"));
            data = (Data) reader.readObject();
            reader.close();
        }
        catch (IOException | ClassNotFoundException e){
            data = new Data();
            System.out.println(e.getMessage());
        }
        MainFrame frame=  new MainFrame(data);
        new UIPanel(frame,data);
    }

}