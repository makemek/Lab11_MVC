package bank.bankAccount;

import mvc.Student;

/**
 * Created by Apipol on 28/03/15.
 */
class BankAccount implements BankAccountAuthorizedAccess {

    @Override
    public BankAccountProxy.TYPE getType() {
        return type;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public Student owner() {
        return owner;
    }

    @Override
    public int id() {
        return id;
    }

    private int balance;
    private int id;
    private Student owner;
    private BankAccountProxy.TYPE type;

    public BankAccount(Student owner, BankAccountProxy.TYPE type) {
        this.owner = owner;
        this.type = type;
    }

    public void deposit(int amt) {
        if(amt <= 0)
            throw new IllegalArgumentException("Amount cannot be zero or negative");

        balance += amt;
    }

    public void withdraw(int amt) {
        if(amt <= 0)
            throw new IllegalArgumentException("Amount cannot be zero or negative");

        if(balance - amt < 0)
            return;

        balance -= amt;
    }
}
