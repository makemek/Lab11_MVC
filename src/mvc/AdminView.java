package mvc;

import bank.bankAccount.BankAccountProxy;

import java.awt.event.ActionListener;

/**
 * A view of Administrator's account
 * Created by MakeMEK on 28/03/15.
 */
public class AdminView extends AccountView {
    //TODO: Implement Administrator's view

    /**
     * Add a listener to "Create Account" button
     * @param event Instructions about what to do after a deposit button is clicked
     */
    public void onAccountCreateEvent(ActionListener event) {
        //TODO: Implement adding a listener to a button
    }

    /**
     * Add a listener to "Delete Account" button
     * @param event Instructions about what to do after a deposit button is clicked
     */
    public void onAccountDeleteEvent(ActionListener event) {
        //TODO: Implement adding a listener to a button
    }

    /**
     * get the selected account's type from the drop-down box
     * @return Bank account's type
     */
    public BankAccountProxy.TYPE getSelectedType() {
        throw new UnsupportedOperationException();
        //TODO: Implement getting data from drop-down box
    }

    /**
     * from text view
     * @return a typed integer indicate id
     */
    public int getAccountID() {
        throw new UnsupportedOperationException();
        //TODO: Implement getting data from textview
    }
}
