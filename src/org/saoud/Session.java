package org.saoud;

import java.io.Serial;
import java.util.ArrayList;

public class Session implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private TwoInt a;
    private TwoInt b;
    private int N;
    private ArrayList<SessionData> sessionData;

    public Session(String str,int amin,int amax,int bmin,int bmax,int N) throws ErrorMan{
        name = str;
        System.out.println("||" +" " + amin +" " + amax +" " + bmin +" " + bmax + " " + N);
        setLimited(amin,amax,"a");
        setLimited(bmin,bmax,"b");
        setN(N);
        sessionData = new ArrayList<>();

    }
    public void addSessionData(SessionData sd) {
        int index = 0;
        while (index < sessionData.size() && compareSessionData(sd, sessionData.get(index)) <= 0) {
            index++;
        }
        sessionData.add(index, sd);
    }

    private int compareSessionData(SessionData sd1, SessionData sd2) {
        int cCountComp = Integer.compare(sd2.getcCount(), sd1.getcCount());
        if (cCountComp != 0) {
            return cCountComp;
        }
        return Integer.compare(sd1.getFullTime(), sd2.getFullTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TwoInt getA() {
        return a;
    }
    public TwoInt getB() {
        return b;
    }

    public void setLimited(int min,int max,String str) throws ErrorMan {
        if (max <= min)
            throw new ErrorMan("Max must be bigger than Min !");
        if (max > 99999 || min < 0)
            throw new ErrorMan("Enter a valid input plz");
        if (str.compareTo("a") == 0){
            a = new TwoInt(min,max);
        }else {
            b = new TwoInt(min,max);
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

    public ArrayList<SessionData> getSessionData() {
        return sessionData;
    }
}
