package org.saoud;

import java.util.ArrayList;

public class Child extends User{

    private ArrayList<SessionData> sessions = new ArrayList<SessionData>();
    public Child(String name, String pass) {
        super(name, pass);
    }
    public SessionData newSession(){
        SessionData newSession = new SessionData();
        sessions.add(newSession);
        return newSession;
    }
    public SessionData getLastesSession(){
        return sessions.get(sessions.size() -1);
    }
}
