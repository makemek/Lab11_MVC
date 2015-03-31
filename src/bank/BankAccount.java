package bank;

import mvc.Student;

import java.util.ArrayList;
import java.util.List;

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

    }

    public void withdraw(int amt) {

    }
}
