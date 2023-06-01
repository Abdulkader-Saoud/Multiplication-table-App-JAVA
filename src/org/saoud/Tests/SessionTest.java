package org.saoud.Tests;

import org.junit.jupiter.api.Test;
import org.saoud.Session;
import org.saoud.ErrorMan;
import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    // Tests to check error handling in setting a - b - n in  a new Session
    @Test
    void setLimited1() {
        assertThrows(ErrorMan.class ,() ->{
            Session session = new Session("test",5,3,2,5,4);
        } );
    }
    @Test
    void setLimited2() {
        assertThrows(ErrorMan.class ,() ->{
            Session session = new Session("test",1,10,10,2,10);
        } );
    }
    @Test
    void setLimited3() {
        assertThrows(ErrorMan.class ,() ->{
            Session session = new Session("test",1,10,1,10,-5);
        } );
    }
    @Test
    void setLimited4() {
        assertThrows(ErrorMan.class ,() ->{
            Session session = new Session("test",-1,10,1,10,10);
        } );
    }
    @Test
    void setLimited5() {
        assertThrows(ErrorMan.class ,() ->{
            Session session = new Session("test",1,10,-1,10,10);
        } );
    }
}