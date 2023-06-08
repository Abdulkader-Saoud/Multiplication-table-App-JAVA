package org.saoud.GUI;

import org.saoud.Data;

public class UIPanel {
    private static Data data;
    private static MainFrame frame;
    public UIPanel(MainFrame frame, Data data){
        this.frame = frame;
        this.data = data;
    }

    public static Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static MainFrame getFrame() {
        return frame;
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }
}
