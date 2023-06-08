package org.saoud;
public class QData implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private TwoInt twoInt;
    private Boolean isCorrect;
    private int time;

    public QData(int a ,int b, Boolean isCorrect, int time) {
        this.twoInt = new TwoInt(a,b);
        this.isCorrect = isCorrect;
        this.time = time;
    }

    public TwoInt getTwoInt() {
        return twoInt;
    }

    public void setTwoInt(TwoInt twoInt) {
        this.twoInt = twoInt;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
