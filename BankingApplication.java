import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create banks
        List<Bank_Interface> bankInterfaces = new ArrayList<>();
        System.out.print("Enter the number of banks: ");
        int numberOfBanks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfBanks; i++) {
            System.out.print("Enter the name of Bank " + (i + 1) + ": ");
            String bankName = scanner.nextLine();
            Bank_Interface bankInterface = new Bank_Interface(bankName);

            System.out.print("Enter the number of branches for " + bankName + ": ");
            int numberOfBranches = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numberOfBranches; j++) {
                System.out.print("Enter the name of Branch " + (j + 1) + " for " + bankName + ": ");
                String branchName = scanner.nextLine();
                bankInterface.addBranch(branchName);
            }
            bankInterfaces.add(bankInterface);
        }

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Display Account\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) break;

            System.out.print("Enter Bank Name: ");
            String bankName = scanner.nextLine();
            Bank_Interface selectedBankInterface = null;

            for (Bank_Interface bankInterface : bankInterfaces) {
                if (bankInterface.getName().equalsIgnoreCase(bankName)) {
                    selectedBankInterface = bankInterface;
                    break;
                }
            }

            if (selectedBankInterface == null) {
                System.out.println("Bank not found!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Branch Name: ");
                    String branchName = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = scanner.nextDouble();
                    selectedBankInterface.createAccount(name, branchName, deposit);
                    break;
                case 2:
                    System.out.print("Enter  Your Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double amount = scanner.nextDouble();
                    selectedBankInterface.deposit(accountNumber, amount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter   Withdraw Amount: ");
                    amount = scanner.nextDouble();
                    selectedBankInterface.withdraw(accountNumber, amount);
                    break;
                case 4:
                    System.out.print("Enter your  Account Number: ");
                    accountNumber = scanner.nextLine();
                    selectedBankInterface.displayAccountDetails(accountNumber);
                    break;
                default:
                    System.out.println("Invalid  your choice!");
            }
        }

        scanner.close();
    }
}
