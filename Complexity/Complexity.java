/*
CS 284 Homework 2
Mitra Modi

For the sake of making counting easier, the counter is made to count from 1
*/

public class Complexity{
//Test method0 from the homework, O(n)
public static void method0(int n){
  int counter = 0;
  int i;
  for (i = 0; i < n; i ++) {
    counter++;
    System.out.println("Operation " + counter);
  }
}

//method1 is an operation that has O(n^2)
public static void method1(int n){
    int counter = 0;
    int i;
    int j;
    for (i = 0; i < n; i ++){
      for (j = 0; j < n; j ++){
        counter ++;
        System.out.println("Operation " + counter);
      }
    }
  }

public static void method4(int n){
  int counter = 0;
  int i;
  int j;
  int k;
  for (i = 0; i < n; i ++){
    for (j = 0; j < n; j ++){
      for (k = 0; k < n; k ++){
        counter ++;
        System.out.println("Operation " + counter);
      }
    }
  }
}

public static void method2(int n){
  int counter = 0;
  int i;
  for (i = 1; i < n; i *= 2){
    counter ++;
    System.out.println("Counter " + counter);
  }
}

public static void method3(int n){
  int counter = 0;
  int i;
  int j;
  for (i = 0; i < n; i ++){
    for (j = 1; j < n; j *= 2){
      counter++;
      System.out.println("Counter " + counter);
    }
  }
}

public static void method5(int n){
  int counter = 0;
  int i;
  for (i = 1; i < n; i *= 2){
    int j = (int) Math.pow(2,i);
    System.out.println("Counter " + counter);
    counter++;
    n = n/j;
  }
}
public static void main(String[] args){
}
}
