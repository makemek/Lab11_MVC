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
