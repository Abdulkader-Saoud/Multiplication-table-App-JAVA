package org.saoud.Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.saoud.Data;
import org.saoud.ErrorMan;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DataSavingTest {
    @BeforeAll
    static void setUp(){
        File file = new File("DataTest.dat");
        if (file.exists())
            file.delete();
    }
    @Test
    void saveThenReadParents() throws ErrorMan {
        Data data = new Data("DataTest.dat");
        data.addUser("test","test1234");
        data.saveData();
        Data data2 = new Data("DataTest.dat");
        assertEquals(0,data2.getParents().getName().compareTo("test"));
    }
    @Test
    void saveThenReadParentsandChild() throws ErrorMan {
        Data data = new Data("DataTest.dat");
        data.addUser("testChild","test1234");
        data.saveData();
        Data data2 = new Data("DataTest.dat");
        assertEquals(data2.getParents().getName().compareTo("test"),0);
        assertEquals(0,data2.getChildren().get(0).getName().compareTo("testChild"));
    }

}