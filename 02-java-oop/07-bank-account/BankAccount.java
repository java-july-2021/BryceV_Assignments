import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingsBalance;
    private double savingsBalance;

    private static int totalAccounts = 0;
    private static double totalMoney = 0.00;

    public BankAccount() {
        // running random account number when created
        this.accountNumber = this.randomAccountNumber();
        this.checkingsBalance = 0;
        this.savingsBalance = 0;
        totalAccounts++;
    }
    // public BankAccount(double checking) {
    //     // running random account number when created
    //     this.accountNumber = this.randomAccountNumber();
    //     this.checkingsBalance = checking;
    //     this.savingsBalance = 0;
    //     totalAccounts++;
    // }
    // public BankAccount(double checking, double saving) {
    //     // running random account number when created
    //     this.accountNumber = this.randomAccountNumber();
    //     this.checkingsBalance = checking;
    //     this.savingsBalance = saving;
    //     totalAccounts++;
    // }

    private String randomAccountNumber () {
        Random r = new Random();
        String accountNumber = "";
        for (int i = 0; i<10; i++) {
            // looping and adding onto existing string an int turned into a string
            accountNumber = accountNumber.concat(String.valueOf(r.nextInt(10)));
        }
        return accountNumber;
    }

    public double getCheckingsBalance() {
        System.out.println(String.format("Checking balance: %.02f", this.checkingsBalance));
        return this.checkingsBalance;
    }
    public double getSavingsBalance() {
        System.out.println("Savings balance: " + String.format("%.2f", this.savingsBalance));
        return this.savingsBalance;
    }
    public double getTotal() {
        double total = this.checkingsBalance + this.savingsBalance;
        System.out.println(String.format("You have a total of: %.2f across checking/savings accounts.", total));
        return total;
    }



    public void depositChecking(double amount) {
        this.checkingsBalance += amount;
        System.out.println("Depositing: " + String.format("%.2f", amount) + " into checking");
    }
    public void depositSaving(double amount) {
        this.savingsBalance += amount;
        System.out.println("Depositing: " + String.format("%.2f", amount) + " into savings");
    }
    public void withdrawChecking(double amount) {
        if (this.checkingsBalance >= amount) {
            this.checkingsBalance -= amount;
            System.out.println("Withdrawing: " + String.format("%.2f", amount) + " from checking");
        }
        else {
            System.out.println("Sorry not enough money in account. Tried withdrawing: " + String.format("%.2f", amount) + ", you have: " + String.format("%.2f", this.checkingsBalance));
        }
    }
    public void withdrawSaving(double amount) {
        if (this.savingsBalance >= amount) {
            this.savingsBalance -= amount;
            System.out.println("Withdrawing: " + String.format("%.2f", amount) + " from savings");
        }
        else {
            System.out.println("Sorry not enough money in account. Tried withdrawing: " + String.format("%.2f", amount) + ", you have: " + String.format("%.2f", this.savingsBalance));
        }
    }
}