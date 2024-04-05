import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Bank bank = new Bank(10000); // Initial bank amount

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        System.out.println("Choose an option:");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("Enter admin password:");
            String password = scanner.next();
            if (password.equals("admin")) {
                Admin admin = new Admin(bank);
                System.out.println("Enter amount to update bank:");
                double amount = scanner.nextDouble();
                admin.manageBankAmount(amount);
                System.out.println("Bank amount updated successfully. New balance: $" + bank.getBankAmount());
            } else {
                System.out.println("Invalid password!");
            }
        } else if (option == 2) {
            System.out.println("Enter PIN:");
            int pin = scanner.nextInt();
            Customer customer = new Customer(pin, 5000, bank); // Initial pin and balance
            System.out.println("Choose an operation:");
            System.out.println("1. Change PIN");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter new PIN:");
                    int newPin = scanner.nextInt();
                    customer.changePin(pin, newPin);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    customer.withdraw(pin, withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    customer.deposit(pin, depositAmount);
                    break;
                default:
                    System.out.println("Invalid operation!");
            }
        } else {
            System.out.println("Invalid option!");
        }

        scanner.close();
    }
}
