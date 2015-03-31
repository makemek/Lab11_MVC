package bank.db;

import bank.bankAccount.BankAccountProxy;
import mvc.Student;

import java.util.*;

/**
 * A mock-up database holding bank account
 * Created by MakeMEK on 28/03/15.
 */
public class AccountDb {

    private List<AccountObserver> observer = new ArrayList<AccountObserver>();
    private Map<Student, List<BankAccountProxy>> acc = new HashMap<Student, List<BankAccountProxy>>();

    public BankAccountProxy createAccount(Student owner, BankAccountProxy.TYPE type) {
        BankAccountProxy proxyAccount = new BankAccountProxy(owner, type);

        if(acc.containsKey(owner))
            acc.get(owner).add(proxyAccount);
        else {
            List<BankAccountProxy> holdingAccount = new ArrayList<BankAccountProxy>();
            holdingAccount.add(proxyAccount);
            acc.put(owner, holdingAccount);
        }

        for(AccountObserver obs: observer)
            obs.onAccountCreate(proxyAccount);

        return proxyAccount;
    }

    public void deleteAccount(BankAccountProxy account) {
        List<BankAccountProxy> holdingAccount = acc.get(account.owner());

        for(AccountObserver obs: observer)
            obs.onAccountDelete(account);

        holdingAccount.remove(account);
    }

    public BankAccountProxy[] getAccount(Student owner) {
        if(!acc.containsKey(owner))
            return null;

        List<BankAccountProxy> accounts = acc.get(owner);
        return accounts.toArray(new BankAccountProxy[accounts.size()]);
    }

    public void addAccountObserver(AccountObserver obs) {
        observer.add(obs);
    }

    public Collection<List<BankAccountProxy>> getAllAccount() {
        return acc.values();
    }
}