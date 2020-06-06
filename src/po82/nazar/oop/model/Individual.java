package po82.nazar.oop.model;

import java.util.Arrays;
import java.util.Objects;

public class Individual implements Client, Cloneable{
    private String title;
    private Account[] accounts  = new Account[16];;
    private int size = 0;
    private int creditScore = 0;



    public Individual(String title) {
        this.title = title;
    }

    public Individual(int size, String title) {
        this.title = title;
        this.accounts = new Account[size];
    }

    public Individual(String title,Account[] accounts) {
        this.title = title;
        this.accounts = accounts;
        this.size = accounts.length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean add(Account account){
        Account[] copy = new Account[accounts.length + 1];
        size++;
        System.arraycopy(accounts, 0, copy, 0, accounts.length);
        copy[accounts.length] = account;
        accounts = copy;
        return true;
    }


    public boolean add(Account account,int index){
        Account[] copy = new Account[accounts.length + 1];
        size++;

        copy[index - 1] = account;

        int i = 0, j = 0;
        while(i < copy.length){
            if(copy[i] == null){
                copy[i] = accounts[j];
                j++;
            }
            i++;
        }
        accounts = copy;
        return true;
    }

    public Account get(int index){
        return accounts[index];
    }

    public Account get(String number){
        for(int i = 0; i<size;i++){
            if(accounts[i].checkNumber(number)) return accounts[i];
        }
        return null;
    }

    public boolean hasAccountWithNumber(String number){
        for(int i = 0; i<size;i++){
            if(accounts[i].checkNumber(number)) return true;
        }
        return false;
    }

    public Account set(Account account,int index){
        Account buf = accounts[index];
        accounts[index] = account;
        return buf;
    }

    public Account remove(int index){
        Account[] copy = new Account[accounts.length - 1];
        Account deletedAccount = accounts[index - 1];

        int i = 0, j = 0;

        while(i < accounts.length){
            if(i != index - 1){
                copy[j] = accounts[i];
                j++;
            }
            i++;
        }
        accounts = copy;
        return deletedAccount;
    }

    public Account remove(String number){
        Account[] copy = new Account[accounts.length - 1];
        Account deletedAccount = null;

        int i = 0, j = 0;

        while(i < accounts.length){
            if(!accounts[i].getNumber().equals(number)){
                copy[j] = accounts[i];
                j++;
            } else {
                deletedAccount = accounts[i];
            }
            i++;
        }
        accounts = copy;
        return deletedAccount;
    }

    public int indexOf(String number){
        for(int i = 0; i<size;i++){
            if(accounts[i].getNumber().equals(number)) return i;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public Account[] getAccounts(){
        return accounts;
    }

    public Account[] getSortedAccountsByBalance(){
        for(int i = 0; i<accounts.length;i++){
            for(int j = 0; j<accounts.length-1;j++){
                if(accounts[j].getBalance() > accounts[j+1].getBalance()){
                    Account tmp = accounts[j];
                    accounts[j] = accounts[j+1];
                    accounts[j+1] = tmp;
                }
            }
        }
        return accounts;
    }

    public double getTotalBalance(){
        double totalBalance = 0;
        for(int i = 0; i<size;i++){
            totalBalance+=accounts[i].getBalance();
        }
        return totalBalance;
    }

    @Override
    public int getCreditScores() {
        return creditScore;
    }

    @Override
    public void addCreditScore(int creditScores) {
        this.creditScore += creditScores;
    }

    @Override
    public Account[] getCreditAccounts() {
        Account[] returnAccounts = new CreditAccount[0];
        Account[] copy;


        for(Account account: accounts){
            if(account instanceof CreditAccount){
                copy = new CreditAccount[returnAccounts.length + 1];
                System.arraycopy(returnAccounts, 0, copy, 0, returnAccounts.length);
                copy[returnAccounts.length] = account;
                returnAccounts = copy;
            }
        }
        return returnAccounts;
    }

    @Override
    public String toString() {
        String returnAccounts = String.format(
                "Client" + "\n"+
                        "name: %s \n" +
                        "credit score: %d", getTitle(), getCreditScores());
        for(Account account: accounts){
            returnAccounts += account.toString() + "\n";
        }
        returnAccounts += "total Balance: " + getTotalBalance();
        return returnAccounts;
    }

    public int hashCode(){
        return Objects.hashCode(getTitle()) ^ Objects.hashCode(getCreditScores()) ^ Objects.hashCode(getAccounts().length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return size == that.size &&
                creditScore == that.creditScore &&
                Objects.equals(title, that.title) &&
                Arrays.equals(accounts, that.accounts);
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public boolean remove(Account account) {
        int ind = 0;
        for(Account acc: accounts){
            if(acc.equals(account)){
                remove(ind);
                return true;
            }
            ind++;
        }
        return false;
    }

    @Override
    public int indexOf(Account account) {
        int ind = 0;
        for(Account acc: accounts){
            if(acc.equals(account)){
                return ind;
            }
            ind++;
        }
        return 0;
    }

    @Override
    public double debtTotal() {
        double sum = 0.0;
        Account[] accounts = getCreditAccounts();
        for(Account credit: accounts){
            sum += credit.getBalance();
        }
        return sum;
    }
}