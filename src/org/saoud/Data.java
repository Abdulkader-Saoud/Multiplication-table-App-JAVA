package org.saoud;

import java.util.ArrayList;

public class Data {
    private ArrayList<User> users;
    private User currentUser;
    private TwoInt a;
    private TwoInt b;
    private int N = 5;

    public Data(){
        users = new ArrayList<User>();
        a = new TwoInt(1,10);
        b = new TwoInt(1,10);
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

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void checkUserAuth(String name, String pass) throws ErrorMan {
        for (User user: users){
            if (user.getName().compareTo(name) == 0 && user.getPass().compareTo(pass) == 0){
                currentUser = user;
                return;
            }
        }
        throw new ErrorMan("This info are Wrong");
    }
    public void addUser(String name, String pass) throws ErrorMan {
        for (User user: users){
            if (user.getName().compareTo(name) == 0)
                throw new ErrorMan("This User Already exists");
        }
        if (pass.length() < 6)
            throw new ErrorMan("Very short Password");
        users.add(new User(name,pass,false));
    }
    public void addUser(User user){
        users.add(user);
    }
}
