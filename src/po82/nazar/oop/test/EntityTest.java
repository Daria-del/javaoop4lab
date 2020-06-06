package po82.nazar.oop.test;

import org.junit.Test;
import po82.nazar.oop.model.*;

import static org.junit.Assert.*;

public class EntityTest {

    Client account;


    public EntityTest(){
        Account[] debitAccounts = new Account[2];
        debitAccounts[0] = new DebitAccount("321", 1321);
        debitAccounts[1] = new DebitAccount("3342", 121);
        account = new Entity("Nazarenko", debitAccounts);
    }

    public void returnAccount(){
        Account[] accounts = account.getAccounts();
        for(Account account: accounts){
            System.out.println("Number: " + account.getNumber() + " Balance: " + account.getBalance());
        }
    }

    @Test
    public void getTitle() {
        System.out.println(account.getTitle());
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void add() {
        returnAccount();
        account.add(new DebitAccount("4322", 3));
        System.out.println("------");
        returnAccount();
    }

    @Test
    public void testAdd() {
        returnAccount();
        account.add(new DebitAccount("4322", 1),2);
        System.out.println("------");
        returnAccount();
    }

    @Test
    public void get() {
        returnAccount();
        System.out.println(account.get(2).getNumber());
    }

    @Test
    public void testGet() {
        returnAccount();
        System.out.println(account.get("321").getBalance());
    }

    @Test
    public void hasAccountWithNumber() {
        System.out.println(account.hasAccountWithNumber("321"));
        System.out.println(account.hasAccountWithNumber("34321"));

    }

    @Test
    public void set() {
        returnAccount();
        account.set(new DebitAccount("321", 324), 2);
        returnAccount();
    }

    @Test
    public void remove() {
        returnAccount();
        account.remove(1);
        returnAccount();
    }

    @Test
    public void testRemove() {
        returnAccount();
        account.remove("3342");
        returnAccount();
    }

    @Test
    public void indexOf() {
        returnAccount();
        System.out.println(account.indexOf("3342"));
        System.out.println(account.indexOf("321"));
    }

    @Test
    public void size() {
    }

    @Test
    public void getAccounts() {
        returnAccount();
    }

    @Test
    public void getSortedAccountsByBalance() {
        Account[] accounts = account.getSortedAccountsByBalance();
        for(Account account: accounts){
            System.out.println("Number: " + account.getNumber() + " Balance: " + account.getBalance());
        }
    }

    @Test
    public void getTotalBalance() {
        System.out.println(account.getTotalBalance());
    }

    @Test
    public void getCreditScores() {
    }

    @Test
    public void addCreditScore() {
    }

    @Test
    public void getCreditAccounts() {
    }
}