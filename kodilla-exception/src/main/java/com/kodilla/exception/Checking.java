package com.kodilla.exception;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

import java.io.File;

public class Checking {
    public static void main(String[] args) throws FileReaderException {
       System.out.println("dziala");
        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}
