package bank;

import mvc.Student;

/**
 * Created by Apipol on 28/03/15.
 */
public interface BankAccountPublicAccess {
    public BankAccountProxy.TYPE getType();
    public int getBalance();
    public Student owner();
    public int id();
}
