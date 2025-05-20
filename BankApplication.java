import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("<----Welcome to the Banking System---->");
        System.out.print("Choose: 1-> Cooperative, 2->Nationalized");
        int bankChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Bank Name: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter Branch Name: ");
        String branchName = scanner.nextLine();

        Bank bank;
        if(bankChoice==1){
            bank = new CooperativeBank(bankName, branchName);
        } else {
            bank = new NationalizedBank(bankName, branchName);
        }

        System.out.println("Select Account Type to Open:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Loan Account");
        int accType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Initial Balance (or Loan Amount): ");
        double balance = scanner.nextDouble();

        Account account;
        switch(accType){
            case 1:
                account = new SavingsAccount(accountNumber, holderName, balance);
                break;
            case 2:
                account = new CurrentAccount(accountNumber, holderName, balance);
                break;
            case 3:
                account = new LoanAccount(accountNumber, holderName, balance);
                break;
            default:
                System.out.println("Invalid account type selected.");
                scanner.close();
                return;
        }
        bank.openAccount(account);

        boolean exit = false;
        while(!exit){
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Account Type");
            System.out.println("5. Show Bank Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    ((AccountOperations) account).deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    ((AccountOperations) account).withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: Rs." + ((AccountOperations) account).getBalance());
                    break;
                case 4:
                    account.showAccountType();
                    break;
                case 5:
                    bank.displayBankInfo();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you for using the Banking System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
