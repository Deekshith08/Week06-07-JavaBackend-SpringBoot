public class LoanAccount extends Account implements AccountOperations {

    public LoanAccount(String num, String name, double b){
        super(num, name, b);
    }

    @Override
    public void deposit(double amount){
        if(amount > 0){
            balance -= amount;
            System.out.println("Paid loan: Rs."+amount+". Remaining Loan Balance: Rs."+balance);
        }else{
            System.out.println("Payment must be greater than 0.");
        }
    }

    @Override
    public void withdraw(double amount){
        System.out.println("Withdrawals not allowed from Loan Account.");
    }

    @Override
    public double getBalance(){
        return balance;
    }

    @Override
    public void showAccountType(){
        System.out.println("Account Type: Loan Account");
    }
}
