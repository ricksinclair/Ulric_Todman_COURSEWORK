package com.company.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App2 {

    public static void main(String[] args) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

            writer.println("File line 1");
            writer.println("File line 2");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Finishing up in the finally block...");
        }
    }
}
