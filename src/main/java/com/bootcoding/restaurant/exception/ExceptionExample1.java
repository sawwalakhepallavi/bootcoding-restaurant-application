package com.bootcoding.restaurant.exception;

import java.util.Scanner;

public class ExceptionExample1 {
    public void testException(){
        do{
            try{
                Scanner sc=new Scanner(System.in);
                int i=Integer.parseInt(sc.next());
                System.out.println("value of Input:"+i);
                System.out.println("I am in try block");
                break;
            }
            catch(Exception ex){
                System.out.println("i m in catch block,plz type only integer value");
                ex.printStackTrace();
            }
        }
        while(true);
    }

    public static void main(String[] args) {
        new ExceptionExample1().testException();
    }
}
