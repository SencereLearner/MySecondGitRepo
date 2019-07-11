package com.learning.example;

import java.util.Scanner;

public class Runner {
  public static void main(String[] args)
  {
    // Collections, loops, if/else if/else, variables, class, methods
    /*
    * Arrays:
    * Indexing
    * Initalizing
    * Setting values
    * Getting values
    **/
    int[] ints = new int[10];
    String[] strings = new String[10];
    char[] alpha = new char[] { 'a', 'b', 'c' };
    ints[0] = 1; // set the value
    int firstEleentOfInts = ints[0]; // get the value
    System.out.println(firstEleentOfInts);
    if(firstEleentOfInts == 0)
    {
      System.out.println("The first element is 0");
    } else if (firstEleentOfInts == 1) {
      System.out.println("The first element is 1");
    } else {
      System.out.println("The first element is not 1 or 0");
    }

    for (int i = 0; i < ints.length; i++) {
      ints[i] = i*2;
      System.out.println("ints["+i+"] = "+ints[i]);
    }


    /*
     *  we have to get user input of the size of the array
     *  we will accept number from the user and add them up and return them
     * */
    Scanner myObj = new Scanner(System.in);
    System.out.println("How many numbers to input");
    int arraySize = myObj.nextInt();
    int[] grades = new int[arraySize];
    System.out.println("Enter the grades: ");
    for (int i = 0; i < arraySize; i++) {
      grades[i] = myObj.nextInt();
    }

     //Add up all the values in the array and print it
    int sum = 0;
    for (int i = 0; i < arraySize; i++){
      sum = sum + grades[i];
    }
    System.out.println(sum);
    for (int i = 0; i < arraySize; i++){
      sum = sum + grades[i];
    }
    System.out.println(sum);
    int avrg = sum/arraySize;
    System.out.println("Avg is" + avrg);

    // grades = {-2, 1, 45, 56 }
    // Min grade
    int min = grades[0];
    for (int i = 0; i < grades.length; i++) {
      int currentGrade = grades[i]; // -56
      if(currentGrade<min) {
       min = currentGrade;
      }
    }
    System.out.println("Min is: " + min);

    // MAX


  }
}