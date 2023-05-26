package org.saoud;

import java.util.ArrayList;

public class SessionData implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String startTime;
    private String childName;
    private ArrayList<QData> qData = new ArrayList<>();
    private int cCount;
    private int fCount;
    private int fullTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public void addQ(QData q){
        qData.add(q);
    }
    public int getcCount(){
        return cCount;
    }

    public ArrayList<QData> getqData() {
        return qData;
    }

    public void setqData(ArrayList<QData> qData) {
        this.qData = qData;
    }

    public void setcCount(int cCount) {
        this.cCount = cCount;
    }

    public int getfCount() {
        return fCount;
    }

    public int getFullTime() {
        return fullTime;
    }

    public void setFullTime(int i){
        fullTime = i;
    }
    public void setfCount(int i){
        fCount = i;
    }
    public void incCount(){
        cCount++;
    }
    public ArrayList<QData> getSessionData() {
        return qData;
    }


}
