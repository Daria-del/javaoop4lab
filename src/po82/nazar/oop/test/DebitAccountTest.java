package po82.nazar.oop.test;

import org.junit.Test;
import po82.nazar.oop.model.Account;
import po82.nazar.oop.model.DebitAccount;

import static org.junit.Assert.*;

public class DebitAccountTest {

    Account account;

    public DebitAccountTest(){
        account = new DebitAccount("156907123409", 132);
    }

    @Test
    public void getNumber() {
        System.out.println(account.getNumber());
    }

    @Test
    public void setNumber() {
        account.setNumber("429");
        getNumber();
    }

    @Test
    public void getBalance() {
        System.out.println(account.getBalance());
    }

    @Test
    public void setBalance() {
        account.setBalance(4);
        getBalance();
    }

    @Test
    public void checkNumber() {
        System.out.println(account.checkNumber("156907123409"));
        System.out.println(account.checkNumber("15699"));
    }
}