import java.util.ArrayList;
import java.util.List;

public class CooperativeBank extends Bank{

    public CooperativeBank(String name, String branchName) {
        super(name, branchName);
    }

    List<Account> coAccounts = new ArrayList<>();

    @Override
    public void openAccount(Account account){
        coAccounts.add(account);
        System.out.println("<-------Cooperative Bank System------->");
        System.out.println("Opening account for: "+account.getHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: Rs." + account.getBalance());
        System.out.println("Account successfully opened at " + bankName + " (" + branchName + ")");
    }

    @Override
    public void displayBankInfo(){
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch Name: " + branchName);
        System.out.println("Bank Code: " + getBankCode());
    }
}
