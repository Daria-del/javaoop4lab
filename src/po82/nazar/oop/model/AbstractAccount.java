package po82.nazar.oop.model;

import java.util.Objects;

public class AbstractAccount implements Account, Cloneable{
    private double balance = 0.0;
    private String number = "";

    protected AbstractAccount(){

    }

    public AbstractAccount(double balance, String number){
        this.balance = balance;
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean checkNumber(String number) {
        return this.number.equals(number);
    }


    @Override
    public String toString() {
        return "Number: " + number + " balance: " + balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAccount that = (AbstractAccount) o;
        return Double.compare(that.balance, balance) == 0 &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance) & Objects.hash(number);
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}