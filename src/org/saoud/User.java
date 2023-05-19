package org.saoud;

import java.util.ArrayList;

public class User {
    private String name;
    private String pass;
    private boolean isAdmin;
    private ArrayList<QData> qData;


    public User(String name, String pass, boolean isAdmin) {
        this.name = name;
        this.pass = pass;
        this.isAdmin = isAdmin;
        this.qData = new ArrayList<>();
    }
    public ArrayList<QData> getSessionData() {
        return qData;
    }
    public void addQ(QData q){
        qData.add(q);
    }
    public void removeAllQ(){
        qData.removeAll(qData);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
