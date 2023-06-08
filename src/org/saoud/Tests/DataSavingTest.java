package org.saoud.Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.saoud.Data;
import org.saoud.ErrorMan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.jupiter.api.Assertions.*;

class DataSavingTest {
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
    //Testing making a parent account
    @Test
    void saveThenReadParents() throws ErrorMan {
        data.addUser("test","test1234");
        data.saveData();
        assertEquals(0,data.getParents().getName().compareTo("test"));
    }
    //Testing making a child account
    @Test
    void saveThenReadParentsandChild() throws ErrorMan {
        data.addUser("testChild","test1234");
        data.saveData();
        assertEquals(0,data.getParents().getName().compareTo("test"));
        assertEquals(0,data.getChildren().get(0).getName().compareTo("testChild"));
    }
    @AfterAll
    public static void done() {
        File file = new File("Data.txt");
        if (file.exists())
            file.delete();
    }
}