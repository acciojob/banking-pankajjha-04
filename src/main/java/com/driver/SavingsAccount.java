package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0); // minimum balance is 0 by default
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        super.withdraw(amount);
    }

    public double getSimpleInterest(int years) {
        // Implement simple interest calculation
        double interest = balance * rate * years;
        return balance + interest;
    }

    public double getCompoundInterest(int times, int years) {
        // Implement compound interest calculation
        double totalAmount = balance * Math.pow((1 + rate / times), times * years);
        return totalAmount;
    }
}
