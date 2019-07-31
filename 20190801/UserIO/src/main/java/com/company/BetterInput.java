package com.company;

import com.company.interfaces.UserIO;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Scanner;

public class BetterInput implements UserIO {

    private String userString;
    private int userInt;
    private double userDouble;
    private long userLong;
    private float userFloat;

    public int readInt( String prompt){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println(prompt);
            userInt = Integer.parseInt(scanner.nextLine());


        } catch(Exception e){


                readInt(prompt);

        }
            return userInt;

    }
    public long readLong( String prompt){
        Scanner scanner = new Scanner(System.in);



        try {
            System.out.println(prompt);
            userLong = Long.parseLong(scanner.nextLine());
        }catch (Exception e){
                readLong(prompt);
        }
            return userLong;

    }
    public double readDouble( String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        try{
        userDouble = Double.parseDouble(scanner.nextLine());
    }catch (Exception e){
                readDouble(prompt);

        }
            return userDouble;

    }
    public float readFloat( String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        try {
            userFloat = Float.parseFloat(scanner.nextLine());
        }catch (Exception e) {
                readFloat(prompt);
            }

            return userFloat;




    }
    public String readString( String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        try{
        userString = scanner.nextLine();
    }catch (Exception e){

                readString(prompt);

        }
            return userString;

        }
    }
