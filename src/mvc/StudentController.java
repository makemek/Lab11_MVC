package mvc;

import bank.AccountDb;
import bank.BankAccountProxy;
import bank.BankAccountPublicAccess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Apipol on 28/03/15.
 */
public class StudentController {

    private BankAccountProxy[] account;
    private StudentView view;
    private Student owner;

    public StudentController(Student owner, StudentView view, AccountDb db) {
        account = db.getAccount(owner);

        this.owner = owner;
        this.view = view;

        for(BankAccountProxy acc: account)
            acc.addBalanceObserver(view);

        view.onWithdrawEvent(new WithdrawEventHandler());
        view.onDepositEvent(new DepositEventHandler());
    }

    private BankAccountProxy findAccount(BankAccountPublicAccess selected) {
        BankAccountProxy proxyAccount = null;
        for(BankAccountProxy b: account)
            if(b == selected) {
                proxyAccount = b;
                break;
            }

        return proxyAccount;
    }

    class WithdrawEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BankAccountPublicAccess selected = view.getSelectedAccount();
            BankAccountProxy proxyAccount = findAccount(selected);

            proxyAccount.withdraw(owner, view.getAmount());
        }
    }

    class DepositEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BankAccountPublicAccess selected = view.getSelectedAccount();
            BankAccountProxy proxyAccount = findAccount(selected);

            if(proxyAccount != null)
                proxyAccount.deposit(owner, view.getAmount());
        }
    }

}



