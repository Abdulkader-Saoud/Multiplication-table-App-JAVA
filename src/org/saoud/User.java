package org.saoud;

import java.util.ArrayList;

public class User  implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String pass;
    private boolean isAdmin;

    private ArrayList<SessionData> sessions = new ArrayList<SessionData>();

    public User(String name, String pass, boolean isAdmin) {
        this.name = name;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }
    public SessionData newSession(){
        SessionData newSession = new SessionData();
        sessions.add(newSession);
        return newSession;
    }
    public SessionData getLastesSession(){
        return sessions.get(sessions.size() -1);
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
