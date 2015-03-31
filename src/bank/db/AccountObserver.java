package bank.db;

import bank.bankAccount.BankAccountProxy;

/**
 * Created by Apipol on 28/03/15.
 */
public interface AccountObserver {
    /**
     * Notify account deletion before it is deleted
     * @param acc An account to be deleted
     */
    public void onAccountDelete(BankAccountProxy acc);

    /**
     * Notify account creation after it is created
     * @param acc A new account
     */
    public void onAccountCreate(BankAccountProxy acc);
}
