class AccountInformation {
    private String accountNumber;
    private Customer_Info bankCustomer;
    private double balance;

    public AccountInformation(String accountNumber, Customer_Info bankCustomer, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.bankCustomer = bankCustomer;
        this.balance = initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer_Info getCustomer() {
        return bankCustomer;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
