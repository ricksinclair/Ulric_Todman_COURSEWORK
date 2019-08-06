package com.company.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App {

    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter(new FileWriter("/Home/foo/output.txt"));

        writer.println("File line 1");
        writer.println("File line 2");

        writer.flush();
        writer.close();
    }
}
