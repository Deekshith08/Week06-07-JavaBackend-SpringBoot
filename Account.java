public abstract class Account {
    private final String accountNumber;
    private final String holderName;
    protected double balance;

    public Account(String num, String name, double b){
        this.accountNumber = num;
        this.holderName = name;
        this.balance = b;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getHolderName(){
        return holderName;
    }

    public double getBalance(){
        return balance;
    }

    public abstract void showAccountType();
}
