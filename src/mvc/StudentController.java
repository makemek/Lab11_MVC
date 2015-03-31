package mvc;

import bank.AccountDb;
import bank.BankAccountProxy;
import bank.BankAccountPublicAccess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface between account database and student view
 * Created by MakeMEK on 28/03/15.
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
        db.addAccountObserver(view);

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

            proxyAccount.withdraw(view.getAmount());
        }
    }

    class DepositEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BankAccountPublicAccess selected = view.getSelectedAccount();
            BankAccountProxy proxyAccount = findAccount(selected);

            proxyAccount.deposit(view.getAmount());
        }
    }

}



