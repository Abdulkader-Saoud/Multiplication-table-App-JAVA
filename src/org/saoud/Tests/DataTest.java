package org.saoud.Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.saoud.Data;
import org.saoud.ErrorMan;
import org.saoud.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    private static Data data;
    @BeforeAll
    public static void setUp(){
        File file = new File("Data.txt");
        if (file.exists())
            file.delete();
        try{
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream("Data.txt"));
            data = (Data) reader.readObject();
            reader.close();
        }
        catch (IOException | ClassNotFoundException e){
            data = new Data();
            System.out.println(e.getMessage());
        }
    }
    // two seesion same name
    @Test
    void checkAddingSession() throws ErrorMan {
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
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName","tpass1234");
            data.checkUserAuth("no","tpass1234");
        });
    }
    @Test
    void checkUserAuth2(){// wrong pass right name
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName","tpass1234");
            data.checkUserAuth("tName","tpass123");
        });
    }
    @Test
    void checkUserAuth3() throws ErrorMan { // info right
        data.checkUserAuth("tName","tpass1234");
    }

    //Test to check error handling
    @Test
    void addUser1() {// check short pass
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName2","tpass");
        });
    }
    @Test
    void addUser2() {// check adding user twice
        assertThrows(ErrorMan.class, () -> {
            data.addUser("tName3","tpass123");
            data.addUser("tName3","tpass123");
        });
    }
    @AfterAll
    public static void done() {
        File file = new File("Data.txt");
        if (file.exists())
            file.delete();
    }
}