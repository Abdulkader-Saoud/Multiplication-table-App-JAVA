package org.saoud;

import java.io.*;
import java.util.ArrayList;

public class Data implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private Parents parents;
    private ArrayList<Child> children;
    private User currentUser;
    private TwoInt a;
    private TwoInt b;
    private int N;
    public Data(){
        try{
            String fileName = "Data.dat";
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
            parents = (Parents)reader.readObject();
            children = (ArrayList<Child>) reader.readObject();
            a = (TwoInt)reader.readObject();
            b = (TwoInt)reader.readObject();
            N = (int) reader.readObject();
            reader.close();
        }
        catch (FileNotFoundException e){
            children = new ArrayList<>();
            a = new TwoInt(1,10);
            b = new TwoInt(1,10);
            N = 5;
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public TwoInt getA() {
        return a;
    }


    public void setA(int min,int max) throws ErrorMan {
        if (max <= min)
            throw new ErrorMan("Max must be bigger than Min !");
        if (max > 100 || min < 0)
            throw new ErrorMan("Enter a valid input plz");

        this.a = new TwoInt(min,max);
    }

    public TwoInt getB() {
        return b;
    }

    public void setLimited(int min,int max,String str) throws ErrorMan {
        if (max <= min)
            throw new ErrorMan("Max must be bigger than Min !");
        if (max > 100 || min < 0)
            throw new ErrorMan("Enter a valid input plz");
        if (str.compareTo("a") == 0){
            a.setA(min);
            a.setB(max);
        }else {
            b.setA(min);
            b.setB(max);
        }

    }

    public int getN() {
        return N;
    }

    public void setN(int n) throws ErrorMan {
        if (N <= 0)
            throw new ErrorMan("Enter a valid input plz");
        N = n;
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
            writer.writeObject(a);
            writer.writeObject(b);
            writer.writeObject(N);

            writer.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
