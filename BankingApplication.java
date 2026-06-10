import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor
    BankAccount(double balance) {
        this.balance = balance;
    }

    // Deposit Method
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    // Withdraw Method
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        }
    }

    // Check Balance Method
    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class BankingApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);

        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}