package com.bootcoding.restaurant.exception;

public class UserService {
    public void test() throws Exception{
        UserHelper userHelper=new UserHelper();
        try{
            userHelper.test();
        }catch (NumberFormatException ex){
            System.err.println(ex.getCause());
            ex.printStackTrace();
            MyException exm=new MyException(ex.getMessage());
            UserServiceException usm=new UserServiceException(ex.getMessage());
            throw usm;
        }
        finally{
            System.out.println("I'm definatly executed!");
        }
    }
}
