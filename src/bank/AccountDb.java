package bank;

import mvc.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A mock-up database holding bank account
 * Created by MakeMEK on 28/03/15.
 */
public class AccountDb {

    private List<AccountObserver> observer = new ArrayList<AccountObserver>();
    private Map<Student, List<BankAccount>> acc = new HashMap<Student, List<BankAccount>>();

    public BankAccountProxy createAccount(Student owner, BankAccount.TYPE type) {
        BankAccount realAccount = new BankAccount(owner, type);

        if(acc.containsKey(owner))
            acc.get(owner).add(realAccount);
        else {
            List<BankAccount> holdingAccount = new ArrayList<BankAccount>();
            holdingAccount.add(realAccount);
            acc.put(owner, holdingAccount);
        }

        return new BankAccountProxy(realAccount);
    }

    public void deleteAccount(BankAccountProxy account) {

    }

    public BankAccountProxy[] getAccount(Student owner) {
        if(!acc.containsKey(owner))
            return null;

        List<BankAccount> accounts = acc.get(owner);
        BankAccountProxy[] proxies = new BankAccountProxy[acc.size()];
        for(int i = 0; i < accounts.size(); ++i)
            proxies[i] = new BankAccountProxy(accounts.get(i));

        return proxies;
    }

    public void addAccountObserver(AccountObserver obs) {
        observer.add(obs);
    }

}
