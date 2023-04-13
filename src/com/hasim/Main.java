package com.hasim;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import static java.util.Locale.CANADA;

public class Main {
    public static void main(String[] args) {
        // Set Location to Canada
        NumberFormat currency = NumberFormat.getCurrencyInstance(CANADA);
        // Read input from user via terminal
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final  byte PERCENT = 100;

        System.out.print("Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Annual interest rate: ");
        float interestRate = scanner.nextFloat();
        System.out.print("Period (years): ");
        int period = scanner.nextInt();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        //Calculate monthly interest
        double monthlyInterestRate = (interestRate/PERCENT)/MONTHS_IN_YEAR;

        double monthlyEmi = principal * ( monthlyInterestRate * ( Math.pow((1+monthlyInterestRate),numberOfPayments) / (Math.pow((1+monthlyInterestRate),numberOfPayments) -1) ));
        String monthlyMortgage = currency.format(monthlyEmi);
        System.out.println("Monthly Mortgage: "+ monthlyMortgage);
    }
}