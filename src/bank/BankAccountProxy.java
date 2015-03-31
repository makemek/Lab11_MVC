package bank;

import mvc.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A virtual bank account created to manage account status notification
 * Created by MakeMEK on 28/03/15.
 */
public class BankAccountProxy implements BankAccountAuthorizedAccess {

    BankAccount account;
    public static enum TYPE {SAVING, CURRENT};

    private List<BalanceObserver> observer = new ArrayList<BalanceObserver>();

    public BankAccountProxy(Student owner, TYPE type) {
        this.account = new BankAccount(owner, type);
    }

    @Override
    public TYPE getType() {
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

    public void deposit(int amt) {
        account.deposit(amt);
        notifyObservers();
    }

    public void withdraw(int amt) {
        account.withdraw(amt);
        notifyObservers();
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
