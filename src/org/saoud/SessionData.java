package org.saoud;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void setStartTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.startTime = dtf.format(now);
    }
    public Boolean writeToCsv() throws IOException {
        File csvFile = new File(childName + ".csv");
        FileWriter fileWriter = new FileWriter(csvFile);
        StringBuilder line1 = new StringBuilder();
        line1.append("a");
        line1.append(',');
        line1.append("b");
        line1.append(',');
        line1.append("answer");
        line1.append(',');
        line1.append("Time");
        line1.append("\n");
        fileWriter.write(line1.toString());
        for (QData qd : qData) {
            StringBuilder line = new StringBuilder();
            line.append(qd.getTwoInt().getA());
            line.append(',');
            line.append(qd.getTwoInt().getB());
            line.append(',');
            line.append((qd.getCorrect() ? "True" : "False"));
            line.append(',');
            line.append(qd.getTime());
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
        return true;
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
