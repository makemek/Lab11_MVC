package bank;

import mvc.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A virtual bank account created to limit access from user and increase security
 * Created by MakeMEK on 28/03/15.
 */
public class BankAccountProxy implements BankAccountPublicAccess {

    BankAccount account;

    private List<BalanceObserver> observer = new ArrayList<BalanceObserver>();

    public BankAccountProxy(BankAccount account) {
        this.account = account;
    }

    @Override
    public BankAccount.TYPE getType() {
        return account.getType();
    }

    @Override
    public int getBalance() {
        return account.getBalance();
    }

    @Override
    public Student owner() {
        return account.owner();
    }

    @Override
    public int id() {
        return account.id();
    }

    public void deposit(Student owner, int amt) {
        if(owner.equals(account.owner())) {
            account.deposit(amt);
            notifyObservers();
        }
    }

    public void withdraw(Student owner, int amt) {
        if(owner.equals(account.owner())) {
            account.withdraw(amt);
            notifyObservers();
        }
    }

    public void addBalanceObserver(BalanceObserver obs) {
        observer.add(obs);
    }

    private void notifyObservers() {
        int bal = getBalance();
        for(BalanceObserver obs: observer) {
            obs.onBalanceChange(this, bal);
        }
    }
}
