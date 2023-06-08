package org.saoud;
public class TwoInt  implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private int a;
    private int b;
    public TwoInt(){
        a = 0;
        b = 0;
    }
    public TwoInt(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
