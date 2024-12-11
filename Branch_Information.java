import java.util.ArrayList;
import java.util.List;

public class Branch_Information {
    private String name;
    private List<AccountInformation> bankAccounts;

    public Branch_Information(String name) {
        this.name = name;
        this.bankAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<AccountInformation> getAccounts() {
        return bankAccounts;
    }

    public void addAccount(AccountInformation bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public AccountInformation findAccount(String accountNumber) {
        for (AccountInformation bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }
}

