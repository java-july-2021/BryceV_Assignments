public class BankTester {
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount();
        bank1.getCheckingsBalance();
        bank1.getSavingsBalance();
        bank1.depositChecking(10.00);
        bank1.getCheckingsBalance();
        bank1.depositSaving(5.25);
        bank1.getSavingsBalance();
        bank1.withdrawChecking(5);
        bank1.getCheckingsBalance();
        bank1.withdrawChecking(6);
        bank1.withdrawSaving(4.00);
        bank1.getSavingsBalance();
        bank1.withdrawSaving(10.00);
    }
}