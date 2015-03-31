package bank;

import mvc.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apipol on 28/03/15.
 */
class BankAccount implements BankAccountPublicAccess {

    @Override
    public TYPE getType() {
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

    public static enum TYPE {SAVING, CURRENT};

    private int balance;
    private int id;
    private Student owner;
    private TYPE type;

    public BankAccount(Student owner, TYPE type) {
        this.owner = owner;
        this.type = type;
    }

    public void deposit(int amt) {

    }

    public void withdraw(int amt) {

    }
}
