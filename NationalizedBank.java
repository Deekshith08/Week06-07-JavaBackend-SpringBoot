import java.util.ArrayList;
import java.util.List;

public class NationalizedBank extends Bank{

    public NationalizedBank(String name, String branchName) {
        super(name, branchName);
    }

    private List<Account> nataccounts = new ArrayList<>();

    @Override
    public void openAccount(Account account){
        nataccounts.add(account);
        System.out.println("<-------Nationalized Bank System------->");
        System.out.println("--- Account Details ---");
        System.out.println("Opening account for: "+account.getHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: Rs." + account.getBalance());
        System.out.println("Account successfully opened at " + bankName + " (" + branchName + ")");
    }

    @Override
    public void displayBankInfo(){
        System.out.println("--- Bank Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch Name: " + branchName);
        System.out.println("Bank Code: " + getBankCode());
    }

    public List<Account> getAccounts() {
        return nataccounts;
    }
}
