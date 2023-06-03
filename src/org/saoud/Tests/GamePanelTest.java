package org.saoud.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.saoud.*;
import org.saoud.GUI.GamePanel;
import org.saoud.GUI.MainFrame;

import static org.junit.jupiter.api.Assertions.*;
public class GamePanelTest {
    private GamePanel gamePanel;
    private MainFrame mainFrame;
    private Data data;
    private Session session;
    private SessionData sessionData;

    @BeforeEach
    public void setUp() throws ErrorMan {
        data = new Data();
        data.setCurrentUser(new Child("ayshy","paskdkasd"));
        mainFrame = new MainFrame(data);
        session = new Session("t1",2,5,2,5,2);
        gamePanel = new GamePanel(mainFrame, data, session);
        gamePanel.setVisible(true);
        sessionData = gamePanel.getSessionData();
    }
    @Test
    public void testGamePanelInitialization() {
        assertNotNull(gamePanel);
        assertTrue(gamePanel.isVisible());
        assertEquals(data, gamePanel.getData());
        assertEquals(mainFrame, gamePanel.getFrame());
        assertEquals(session, gamePanel.getSe());
    }
    @Test
    public void testSetTQuestion() {
        assertTrue(gamePanel.getAb().getA() >= session.getA().getA());
        assertTrue(gamePanel.getAb().getA() <= session.getA().getB());
        assertTrue(gamePanel.getAb().getB() >= session.getB().getA());
        assertTrue(gamePanel.getAb().getB() <= session.getB().getB());
    }
}
