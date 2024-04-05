public class Bank {
    private double bankAmount;

    public Bank(double initialAmount) {
        this.bankAmount = initialAmount;
    }

    public double getBankAmount() {
        return bankAmount;
    }

    public synchronized void updateBankAmount(double amount) {
        bankAmount += amount;
        if (bankAmount < 0) {
            System.out.println("Bank amount cannot be negative!");
            bankAmount -= amount; // Revert the change
        }
    }
}
