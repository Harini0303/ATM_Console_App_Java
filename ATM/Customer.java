public class Customer {
    private int pin;
    private double accountBalance;
    private Bank bank;

    public Customer(int pin, double initialBalance, Bank bank) {
        this.pin = pin;
        this.accountBalance = initialBalance;
        this.bank = bank;
    }

    public int getPin() {
        return pin;
    }

    public void changePin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid PIN. PIN change failed.");
        }
    }

    public void withdraw(int enteredPin, double amount) {
        if (this.pin == enteredPin && amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            bank.updateBankAmount(-amount);
            System.out.println("$" + amount + " withdrawn successfully. Current Balance: $" + accountBalance);
        } else {
            System.out.println("Withdrawal failed: Insufficient funds or invalid PIN.");
        }
    }

    public void deposit(int enteredPin, double amount) {
        if (this.pin == enteredPin && amount > 0) {
            accountBalance += amount;
            bank.updateBankAmount(amount);
            System.out.println("$" + amount + " deposited successfully. Current Balance: $" + accountBalance);
        } else {
            System.out.println("Deposit failed: Invalid amount or PIN.");
        }
    }
}
