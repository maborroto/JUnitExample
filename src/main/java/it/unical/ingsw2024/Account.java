package it.unical.ingsw2024;

public class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("L'importo del deposito deve essere positivo");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("L'importo del prelievo deve essere positivo");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Fondi insufficienti");
        }
        balance -= amount;
    }

    public void transfer(Account toAccount, double amount) {
        this.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void applyMonthlyFee() {
        balance += 5.0;
    }
}
