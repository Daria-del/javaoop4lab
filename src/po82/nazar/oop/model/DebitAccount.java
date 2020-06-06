package po82.nazar.oop.model;

import java.util.Objects;

public class DebitAccount extends AbstractAccount implements Cloneable{

    public DebitAccount() {

    }

    public DebitAccount(String number, double balance) {
        super(balance , number);
    }

    @Override
    public String toString() {
        return String.format("Debit account number: %s balance: %f", getNumber(), getBalance());
    }

    public int hashCode(){
        return  53 * super.hashCode();
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}
