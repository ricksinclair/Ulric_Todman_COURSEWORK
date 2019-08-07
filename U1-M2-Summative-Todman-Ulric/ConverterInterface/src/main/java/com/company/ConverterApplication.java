package com.company;

import com.company.interfaces.Converter;

public class ConverterApplication {

    public static void main(String[] args) {
        Converter converterIf = new ConverterIf();
        Converter converterSwitch = new ConverterSwitch();

        for(int i =1 ; i <13; i++){
            System.out.println(converterIf.convertMonth(i) +" provided by If variant.");
            System.out.println(converterSwitch.convertMonth(i) +" provided by Switch variant.");
        }

        for(int i = 1; i<8;i++){
            System.out.println(converterIf.convertDay(i)+" provided by If variant");
            System.out.println(converterSwitch.convertDay(i)+" provided by Switch variant");
        }
    }
}
