package com.company;

import com.company.interfaces.UserIO;
import java.util.Scanner;
public class Input implements UserIO {

    public int readInt( String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        int userNumber = Integer.parseInt(scanner.nextLine());
        return userNumber;
    }
    public long readLong( String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        long userNumber = Long.parseLong(scanner.nextLine());
        return userNumber;
    }
    public double readDouble( String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        double userNumber = Double.parseDouble(scanner.nextLine());
        return userNumber;
    }
    public float readFloat( String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        float userNumber = Float.parseFloat(scanner.nextLine());
        return userNumber;
    }
    public String readString( String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userString = scanner.nextLine();
        return userString;
    }

}
