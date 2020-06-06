package po82.nazar.oop.model;

public interface Client {
    public String getTitle();
    public void setTitle(String title);
    public boolean add(Account account);
    public boolean add(Account account,int index);
    public Account get(int index);
    public Account get(String number);
    public boolean hasAccountWithNumber(String number);
    public Account set(Account account,int index);
    public Account remove(int index);
    public Account remove(String number);
    public int size();
    public Account[] getAccounts();
    public Account[] getSortedAccountsByBalance();
    public double getTotalBalance();
    public int indexOf(String number);
    public int getCreditScores();
    public void addCreditScore(int creditScores);
    default ClientStatus getStatus(int CreditScoreBound){
        return ClientStatus.fromId(CreditScoreBound);
    };
    public Account[] getCreditAccounts();
    public boolean remove(Account account);
    public int indexOf(Account account);
    public double debtTotal();
}
