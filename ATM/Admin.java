public class Admin {
    private Bank bank;

    public Admin(Bank bank) {
        this.bank = bank;
    }

    public void manageBankAmount(double amount) {
        bank.updateBankAmount(amount);
    }
}
