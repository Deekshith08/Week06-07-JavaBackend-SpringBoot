public class CurrentAccount extends Account implements AccountOperations{

    public CurrentAccount(String num, String name, double b){
        super(num, name, b);
    }

    @Override
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Deposited: Rs."+amount+" into Current Account. New Balance: Rs."+balance);
        }else{
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount){
        if(amount>0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: Rs."+amount+" from Current Account. Remaining Balance: Rs."+balance);
        }else{
            System.out.println("Invalid withdrawal or insufficient funds.");
        }
    }

    @Override
    public double getBalance(){
        return balance;
    }

    @Override
    public void showAccountType(){
        System.out.println("Account Type: Current Account");
    }
}
