package org.saoud.Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.saoud.Data;
import org.saoud.ErrorMan;
import org.saoud.Session;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    // two seesion same name
    @BeforeAll
    static void setUp(){
        File file = new File("DataTest.dat");
        if (file.exists())
            file.delete();
    }
    @Test
    void checkAddingSession() throws ErrorMan {
        Data data = new Data("DataTest.dat");
        Session session = new Session("test",1,10,2,5,4);
        Session session2 = new Session("test",1,10,2,5,4);
        data.AddSession(session);
        assertThrows(ErrorMan.class ,() ->{
            data.AddSession(session2);
        } );
    }
    // test wrong info login
    @Test
    void checkUserAuth(){ // wrong name right pass
        Data data = new Data("DataTest.dat");
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName","tpass1234");
            data.checkUserAuth("no","tpass1234");
        });
    }
    @Test
    void checkUserAuth2(){// wrong pass right name
        Data data = new Data("DataTest.dat");
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName","tpass1234");
            data.checkUserAuth("tName","tpass123");
        });
    }
    @Test
    void checkUserAuth3() throws ErrorMan { // info right
        Data data = new Data("DataTest.dat");
        data.addUser("tName","tpass1234");
        data.checkUserAuth("tName","tpass1234");
    }

    //Test to check error handling
    @Test
    void addUser1() {// check short pass
        Data data = new Data("DataTest.dat");
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName","tpass");
        });
    }
    @Test
    void addUser2() {// check adding user twice
        Data data = new Data("DataTest.dat");
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName","tpass123");
            data.addUser("tName","tpass123");
        });
    }
}