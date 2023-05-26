package org.saoud;

import java.io.Serial;

public class Session implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private TwoInt a;
    private TwoInt b;
    private int N;

    public Session(String str,int amin,int amax,int bmin,int bmax,int N) throws ErrorMan{
        name = str;
        setLimited(amin,amax,"a");
        setLimited(bmin,bmax,"b");
        this.N = N;
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


}
