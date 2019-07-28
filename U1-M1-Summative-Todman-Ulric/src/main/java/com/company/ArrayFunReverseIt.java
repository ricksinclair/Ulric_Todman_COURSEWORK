package com.company;

public class ArrayFunReverseIt {

    public static void main(String[] args) {

        int[] starterArray = {1,2,3,4,5};
        int[] reverseArray= new int[5];
        int j = 0; //setting j to the 1st index of the newly created reverseArray


        for(int i = starterArray.length-1; i > -1; i--){//we are going to start at the end of the starterArray.

            reverseArray[j]=starterArray[i]; //since arrays are same size no need to traverse multiple times.
            j++;//just increment j and decrement i after setting last of starter to first of reverse.

            }

        //Then print all elements in each.
        for(int elem : starterArray){
            System.out.println(elem);
        }

        for(int elem : reverseArray){
            System.out.println(elem);
        }



    }


    }

