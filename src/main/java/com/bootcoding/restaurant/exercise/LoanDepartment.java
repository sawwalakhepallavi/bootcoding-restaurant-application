package com.bootcoding.restaurant.exercise;

public class LoanDepartment {
    public static void main(String[] args) {
        double amount=1000;
        int year=5;
        double interest=10;
        LoanDepartment ld=new LoanDepartment();
        double totalPayableAmount=ld.calculateInterest(amount,year,interest);
        System.out.println("Loan Amount:"+amount+"Total Loan Payable Amount:"+totalPayableAmount);

    }
    public double calculateInterest(double amount,int noOfYear,double interest){
        double interestMultiplier=1+interest/100;
        double totalPayableAmount=amount;
        for(int i=1;i<=noOfYear;i++){
            totalPayableAmount=totalPayableAmount * interestMultiplier;
        }
        return totalPayableAmount;
    }
}
