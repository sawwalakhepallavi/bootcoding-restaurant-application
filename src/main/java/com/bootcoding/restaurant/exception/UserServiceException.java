package com.bootcoding.restaurant.exception;

public class UserServiceException extends Exception {
    public UserServiceException(String message){
        super();
        System.out.println(" UserServiceException Invope");
    }
    public UserServiceException(String message,Throwable t){
        super(message,t);
        System.out.println("Throwable invope");
    }
}
