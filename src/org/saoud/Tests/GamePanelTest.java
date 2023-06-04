package org.saoud.Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.saoud.*;
import org.saoud.GUI.GamePanel;
import org.saoud.GUI.MainFrame;
import org.saoud.GUI.UIPanel;

import java.awt.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
public class GamePanelTest {
    private GamePanel gamePanel;
    private Session session;
    private SessionData sessionData;

    @BeforeEach
    void setUp() throws ErrorMan {
        Data data = new Data("DataTest.dat");
        data.setCurrentUser(new Child("ayshy","paskdkasd"));
        MainFrame mainFrame = new MainFrame(data);
        new UIPanel(mainFrame,data);
        session = new Session("t1",2,5,2,5,2);
        gamePanel = new GamePanel(session);
        gamePanel.setVisible(true);
        sessionData = gamePanel.getSessionData();
    }

    @Test
    void testGamePanelInitialization() {
        assertNotNull(gamePanel);
        assertTrue(gamePanel.isVisible());
        assertEquals(session, gamePanel.getSe());
    }
    @Test
    void testSetTQuestion() {
        // check if the numbers generated are in the limits
        assertTrue(gamePanel.getAb().getA() >= session.getA().getA());
        assertTrue(gamePanel.getAb().getA() <= session.getA().getB());
        assertTrue(gamePanel.getAb().getB() >= session.getB().getA());
        assertTrue(gamePanel.getAb().getB() <= session.getB().getB());
    }
    @Test
    void testButtonWorkforTrue(){
        // check Right answer actions
        int cCount = gamePanel.getSessionData().getcCount();
        gamePanel.getjSpinner1().setValue(gamePanel.getAb().getA() * gamePanel.getAb().getB());
        gamePanel.getjButton1().doClick();
        assertTrue(gamePanel.getjButton1().getForeground() == Color.green);
        assertEquals(cCount +1,gamePanel.getSessionData().getcCount());
    }
    @Test
    void testButtonWorkforFalse(){
        // check false answer actions
        int cCount = gamePanel.getSessionData().getcCount();
        gamePanel.getjSpinner1().setValue(gamePanel.getAb().getA() * gamePanel.getAb().getB() -1);
        gamePanel.getjButton1().doClick();
        assertTrue(gamePanel.getjButton1().getForeground() == Color.red);
        assertEquals(cCount ,gamePanel.getSessionData().getcCount());
    }
}
