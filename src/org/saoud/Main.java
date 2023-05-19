package org.saoud;


public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        User me = new User("asd","asd",true);
        User me2 = new User("sdf","sdf",false);
        data.addUser(me);
        data.addUser(me2);
        data.setCurrentUser(me); //
        MainFrame mainFrame = new MainFrame(data);
    }
}