package com.ulrictodman;

public class Sanitizer {
    private boolean isInteger;
    private String decimalRegex =  "\\d++\\.??\\d*?";
    private String integerRegex =  "\\d++";



    private int generateInteger(int number){
        return number;

    }

    private double generateDouble(double number){
        return number;
    }
    public void sanitizeNumber(String userInput){

        if(userInput.matches(integerRegex)){
            int userNumber = Integer.parseInt(userInput);
            System.out.printf("last input was single digit , parsing as integer. %d\n", userNumber);
            generateInteger(userNumber);


        }else if(userInput.matches(decimalRegex)){
            System.out.printf("last input was a double. Parsing double..\n");
            double userNumber = Double.parseDouble(userInput);
            generateDouble(userNumber);

        }else{
            System.out.printf("Invalid input.\n");
        }



    }
}
