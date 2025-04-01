class Bank {
    String bankName;

    Bank() {
        this("Default Bank");
        System.out.println("Default Bank Constructor");
    }

    Bank(String name) {
        this.bankName = name;
        System.out.println("Bank: " + bankName);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Bank bank2 = new Bank("ABC Bank");
    }
}
