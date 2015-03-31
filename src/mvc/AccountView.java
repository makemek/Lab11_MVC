package mvc;

import bank.AccountObserver;
import bank.BalanceObserver;
import bank.BankAccountPublicAccess;

/**
 * A GUI View of account details consists of a table of
 * AccountID, Owner's name, AccountType, and Balance
 */
public abstract class AccountView implements BalanceObserver, AccountObserver {

    // TODO: Implement GUI View

    /**
     * Return the selected account from the table
     * @return An interface to access the real bank account
     */
    public BankAccountPublicAccess getSelectedAccount() {
        //TODO: Implement this function
        return null;
    }

    @Override
    public void onAccountDelete(BankAccountPublicAccess acc) {
        // TODO: Implement what to display when account is going to be deleted
    }

    @Override
    public void onAccountCreate(BankAccountPublicAccess acc) {
        // TODO: Implement what to display when account is going to be created
    }

    @Override
    public void onBalanceChange(BankAccountPublicAccess acc, int bal) {
        // TODO: Implement what to display when balance changes
    }

}
