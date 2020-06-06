package po82.nazar.oop.model;

import java.util.Objects;

public class CreditAccount extends AbstractAccount implements Credit, Cloneable{
    double APR = 30;

    public CreditAccount(){

    }
    public CreditAccount(String number, double balance, double APR){
        super(balance, number);
        this.APR = APR;
    }
    @Override
    public double getAPR() {
        return APR;
    }

    @Override
    public void setAPR(double APR) {
        this.APR = APR;
    }

    @Override
    public String toString() {
        return String.format("Credit Account - number: %s balance %f APR %f", getNumber(), getBalance(),getAPR());
    }

    public int hashCode(){
        return 71 * super.hashCode();
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

enum ClientStatus{
    BAD(-4),
    RISKY(-2),
    GOOD(0),
    GOLD(3),
    PLATINUM(5);

    private int creditScoreBound;

    ClientStatus(int n){
        this.creditScoreBound = n;
    }

    Integer getCreditScoreBound(){
        return creditScoreBound;
    }

    public static ClientStatus fromId(Integer id) {
        for (ClientStatus status : ClientStatus.values()) {
            if (status.getCreditScoreBound() >= id)
                return status;
        }
        return null;
    }
}

