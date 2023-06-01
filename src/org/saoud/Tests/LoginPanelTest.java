package org.saoud.Tests;

import org.junit.jupiter.api.Test;
import org.saoud.Data;
import org.saoud.GUI.LoginPanel;
import org.saoud.GUI.MainFrame;
class LoginPanelTest {
    @Test
    void registerTest(){
        Data data = new Data();
        LoginPanel panel = new LoginPanel(new MainFrame(data),data,"Register",1);
    }

}