package week3lab;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Loan(){
        this.loanAmount = 1000; //Set default loan amount to 1000 as specified in lab brief
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public int getNumberOfYears(){
        return numberOfYears;
    }

    public double getLoanAmount(){
        return loanAmount;
    }

    public Date getLoanDate(){
        long millis = System.currentTimeMillis();
        Date loanDate = new Date(millis);
        return loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment(){
        double monthlyIntRate = annualInterestRate / 12 / 100;
        double monthlyPayment = (loanAmount * monthlyIntRate)/(1 - (1/Math.pow((1+monthlyIntRate), numberOfYears*12)));
        return monthlyPayment;

    }

    public double getTotalPayment(){
        double totalPayment = this.getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }
}
