package po82.nazar.oop.model;

public interface Account {
    public String getNumber();
    public void setNumber(String number);
    public double getBalance();
    public void setBalance(double balance);
    public boolean checkNumber(String number);
}
