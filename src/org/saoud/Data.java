package org.saoud;

import java.io.*;
import java.util.ArrayList;

public class Data implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private Parents parents;
    private ArrayList<Child> children = new ArrayList<>() ;
    private ArrayList<Session> sessions = new ArrayList<>() ;
    private User currentUser;

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void AddSession(Session newSe) throws ErrorMan{
        for (Session se : sessions){
            if (se.getName().compareTo(newSe.getName()) == 0)
                throw new ErrorMan("Try different name");
        }
        sessions.add(newSe);
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public Child getChild() {
        if (currentUser instanceof Child)
            return (Child)currentUser;
        return null;
    }
    public Parents getParents(){
        return parents;
    }
    public boolean isAdmin(){
        return parents == currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void checkUserAuth(String name, String pass) throws ErrorMan {
        if (parents.getName().compareTo(name) == 0 && parents.getPass().compareTo(pass) == 0){
            currentUser = parents;
            return;
        }
        for (User user: children){
            if (user.getName().compareTo(name) == 0 && user.getPass().compareTo(pass) == 0){
                currentUser = user;
                return;
            }
        }
        throw new ErrorMan("This info are Wrong");
    }
    public void addUser(String name, String pass) throws ErrorMan {
        if (parents == null){
            setParents(name,pass);
            return;
        }
        for (User user: children){
            if (user.getName().compareTo(name) == 0)
                throw new ErrorMan("This User Already exists");
        }
        if (parents.getName().compareTo(name) == 0)
            throw new ErrorMan("This User Already exists");
        if (pass.length() < 6)
            throw new ErrorMan("Very short Password");

        children.add(new Child(name,pass));
    }
    public void setParents (String name, String pass) throws ErrorMan {
        if (pass.length() < 6)
            throw new ErrorMan("Very short Password");

        parents = new Parents(name,pass);
        setCurrentUser(parents);
    }

    public void saveData(){
        try{
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("Data.txt",false));
            writer.writeObject(this);
            writer.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Child> getChildren() {
        return children;
    }
}
