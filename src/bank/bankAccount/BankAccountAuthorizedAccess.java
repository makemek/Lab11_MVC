package bank.bankAccount;

/**
 * Supplement interface
 * Created by Apipol on 31/03/15.
 */
public interface BankAccountAuthorizedAccess extends BankAccountPublicAccess{
    public void deposit(int amt);
    public void withdraw(int amt);
}
