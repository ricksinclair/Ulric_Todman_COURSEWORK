package com.company;

public class App {

        public static int subtract(int a, int b){

            return a-b;
        }
        public static int subtractOrZero(int a, int b){
            if ((a-b)<0)
                return 0;
            else
                return a-b;
        }

        public static int max(int a, int b, int c){
            if(a>b&&a>c) {
                return a;
            }else if (b>a && b> c){
                return b;
            }else{
                return c;
            }
        }

        public static int min(int a, int b, int c){
            if(a<b&&a<c) {
                return a;
            }else if (b<a && b< c){
                return b;
            }else{
                return c;
            }
        }

        public static boolean isLarger(int a, int b){
            if(a>b){
                return true;
            }
            else{
                return false;
            }
        }
        public static void main(String[] args) {
            System.out.println(subtract(20,5));//15
            System.out.println(subtractOrZero(10,5));//5
            System.out.println(subtractOrZero(5,10));//0
            System.out.println(min(5,6,7));//5
            System.out.println(min(5,8,4));//4
            System.out.println(max(5,6,7));//7
            System.out.println(max(5,8,4));//8
            System.out.println( isLarger(10,5));//true
            System.out.println(isLarger(5,10));//false
        }

    }



