package bank.bankAccount;

import bank.bankAccount.BankAccountPublicAccess;

/**
 * Created by Apipol on 28/03/15.
 */
public interface BalanceObserver {

    /**
     * An event notified when account's balance change
     * @param acc An affected account
     * @param bal New balance
     */
    public void onBalanceChange(BankAccountPublicAccess acc, int bal);
}
