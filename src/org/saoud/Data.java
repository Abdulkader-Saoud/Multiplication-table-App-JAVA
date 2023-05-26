package org.saoud;

import java.io.*;
import java.util.ArrayList;

public class Data implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private Parents parents;
    private ArrayList<Child> children;
    private ArrayList<Session> sessions;
    private User currentUser;


    public Data(){
        try{
            String fileName = "Data.dat";
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
            parents = (Parents)reader.readObject();
            children = (ArrayList<Child>) reader.readObject();
            sessions = (ArrayList<Session>) reader.readObject();
            reader.close();
        }
        catch (FileNotFoundException e){
            children = new ArrayList<>();
            sessions = new ArrayList<>();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

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
        return (Child) currentUser;
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
        for (User user: children){
            if (user.getName().compareTo(name) == 0 && user.getPass().compareTo(pass) == 0){
                currentUser = user;
                return;
            }
        }
        if (parents.getName().compareTo(name) == 0 && parents.getPass().compareTo(pass) == 0){
            currentUser = parents;
            return;
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
            String fileName = "Data.dat";
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName,false));
            writer.writeObject(parents);
            writer.writeObject(children);
            writer.writeObject(sessions);
            writer.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
