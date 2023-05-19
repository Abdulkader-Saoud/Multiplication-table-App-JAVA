package org.saoud;

import java.io.IOException;

public class ErrorMan extends IOException {
    public ErrorMan(String text){
        super(text);
    }
}
