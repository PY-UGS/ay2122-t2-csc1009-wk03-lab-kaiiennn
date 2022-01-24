package week3lab;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter annual interest rate (for example: 8.25): ");
        double annualInt = input.nextDouble();

        System.out.print("Enter number of years as an integer: ");
        int noOfYears = input.nextInt();

        System.out.print("Enter loan amount (for example: 1200000.95): ");
        double loanAmount = input.nextDouble();

        Loan loan1 = new Loan(annualInt, noOfYears, loanAmount);

        System.out.print("The loan was created on " + loan1.getLoanDate());

        System.out.format("%nThe monthly payment is %.2f", loan1.getMonthlyPayment());

        System.out.format("%nThe total payment is %.2f", loan1.getTotalPayment());
    }
}
