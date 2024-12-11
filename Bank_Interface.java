import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank_Interface extends Bankingmanagement {
    private String name;
    private List<Branch_Information> branchInformations;

    public Bank_Interface(String name) {
        this.name = name;
        this.branchInformations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBranch(String branchName) {
        branchInformations.add(new Branch_Information(branchName));
    }

    public Branch_Information findBranch(String branchName) {
        for (Branch_Information branchInformation : branchInformations) {
            if (branchInformation.getName().equalsIgnoreCase(branchName)) {
                return branchInformation;
            }
        }
        return null;
    }

    @Override
    public void createAccount(String name, String branchName, double initialDeposit) {
        Branch_Information branchInformation = findBranch(branchName);
        if (branchInformation == null) {
            System.out.println("Branch not found!");
            return;
        }
        String accountNumber = "AC" + new Random().nextInt(10000);
        Customer_Info bankCustomer = new Customer_Info(name, "C" + new Random().nextInt(1000));
        AccountInformation bankAccount = new AccountInformation(accountNumber, bankCustomer, initialDeposit);
        branchInformation.addAccount(bankAccount);
        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        for (Branch_Information branchInformation : branchInformations) {
            AccountInformation bankAccount = branchInformation.findAccount(accountNumber);
            if (bankAccount != null) {
                bankAccount.deposit(amount);
                System.out.println("Deposit successful! New Balance: " + bankAccount.getBalance());
                return;
            }
        }
        System.out.println("Account not found!");
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        for (Branch_Information branchInformation : branchInformations) {
            AccountInformation bankAccount = branchInformation.findAccount(accountNumber);
            if (bankAccount != null) {
                if (bankAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful! New Balance: " + bankAccount.getBalance());
                } else {
                    System.out.println("Insufficient balance!");
                }
                return;
            }
        }
        System.out.println("Account not found!");
    }

    @Override
    public void displayAccountDetails(String accountNumber) {
        for (Branch_Information branchInformation : branchInformations) {
            AccountInformation bankAccount = branchInformation.findAccount(accountNumber);
            if (bankAccount != null) {
                System.out.println("Account Number: " + bankAccount.getAccountNumber());
                System.out.println("Customer Name: " + bankAccount.getCustomer().getName());
                System.out.println("Balance: " + bankAccount.getBalance());
                return;
            }
        }
        System.out.println("Account not found!");
    }
}
