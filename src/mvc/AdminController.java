package mvc;

import bank.AccountDb;
import bank.BankAccountProxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Apipol on 28/03/15.
 */
public class AdminController {

    private AdminView view;
    private AccountDb db;

    public AdminController(AdminView view, AccountDb db) {
        this.view = view;
        this.db = db;

        db.addAccountObserver(view);

        Collection<List<BankAccountProxy>> accounts = db.getAllAccount();
        for(List<BankAccountProxy> holdingAccount: accounts)
            for(BankAccountProxy account: holdingAccount)
                account.addBalanceObserver(view);
    }
}
