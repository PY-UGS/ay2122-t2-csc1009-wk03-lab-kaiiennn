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
        double loanAmount = this.getLoanAmount();
        double intRate = this.getAnnualInterestRate() / 12 / 100;
        int noOfYears = this.getNumberOfYears();
        double monthlyPayment = (loanAmount * intRate)/(1 - (1/Math.pow((1+intRate), noOfYears*12)));
        return monthlyPayment;

    }

    public double getTotalPayment(){
        double totalPayment = this.getMonthlyPayment() * this.getNumberOfYears() * 12;
        return totalPayment;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter annual interest rate (for example: 8.25): ");
        double annualInt = input.nextDouble();

        System.out.print("Enter number of years as an integer: ");
        int noOfYears = input.nextInt();

        System.out.print("Enter loan amount (for example: 1200000.95): ");
        double loanAmount = input.nextDouble();

        Loan loan1 = new Loan(annualInt, noOfYears, loanAmount);

        System.out.println("The loan was created on " + loan1.getLoanDate());

        System.out.println("The monthly payment is " + df.format(loan1.getMonthlyPayment()));

        System.out.println("The total payment is " + df.format(loan1.getTotalPayment()));
    }
}
