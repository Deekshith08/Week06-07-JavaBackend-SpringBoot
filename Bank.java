public abstract class Bank {
    String bankName;
    String branchName;
    static final String BANK_CODE_PREFIX = "BANK-";
    private String bankCode;
    static int bankCounter = 100;

    public Bank(String name, String branchName){
        this.bankName = name;
        this.branchName = branchName;
        this.bankCode = generateBankCode();
    }

    public abstract void openAccount(Account account);

    public abstract void displayBankInfo();

    public String generateBankCode(){
        return BANK_CODE_PREFIX+(++bankCounter);
    }

    public String getBankCode(){
        return bankCode;
    }
}
