package po82.nazar.oop.test;

import org.junit.Test;
import po82.nazar.oop.model.*;

import static org.junit.Assert.*;

public class AccountManagerTest {

    AccountManager a;

    public AccountManagerTest(){
        Account[] debitAccounts = new Account[2];
        debitAccounts[0] = new DebitAccount("321", 1321);
        debitAccounts[1] = new DebitAccount("3342", 121);

        Client[] clients = {
                new Individual("Nazarenko", debitAccounts),
                new Entity("Lesha", debitAccounts),
                new Individual("Misha", debitAccounts)
        };

        a = new AccountManager(clients);
    }

    public void returnClients(){
        Client[] clients = a.getClients();

        for(Client client:clients){
            System.out.println(client.getTitle());
        }
    }

    @Test
    public void add() {
        returnClients();
        Account[] debitAccounts = new Account[2];
        debitAccounts[0] = new DebitAccount("321", 1321);
        debitAccounts[1] = new DebitAccount("3342", 121);

        a.add(new Individual("Misdaha", debitAccounts));
        System.out.println("----");
        returnClients();
    }

    @Test
    public void testAdd() {
        returnClients();
        Account[] debitAccounts = new Account[2];
        debitAccounts[0] = new DebitAccount("321", 1321);
        debitAccounts[1] = new DebitAccount("3342", 121);

        a.add(new Individual("test", debitAccounts),2);
        System.out.println("----");
        returnClients();
    }

    @Test
    public void get() {
        System.out.println(a.get(2).getTitle());
    }

    @Test
    public void set() {
        returnClients();
        Account[] debitAccounts = new Account[2];
        debitAccounts[0] = new DebitAccount("321", 1321);
        debitAccounts[1] = new DebitAccount("3342", 121);

        a.set(new Individual("test", debitAccounts),1);
        System.out.println("----");
        returnClients();
    }

    @Test
    public void remove() {
        returnClients();

        a.remove(1);
        System.out.println("----");
        returnClients();
    }

    @Test
    public void size() {
    }

    @Test
    public void getClients() {
    }

    @Test
    public void getSortedIndividualsByTotalBalance() {
        Client[] clients = a.getSortedIndividualsByTotalBalance();

        for(Client client:clients){
            System.out.println(client.getTotalBalance());
        }

    }

    @Test
    public void getAccountWithNumber() {

    }

    @Test
    public void removeAccount() {
    }

    @Test
    public void setAccount() {
    }
}