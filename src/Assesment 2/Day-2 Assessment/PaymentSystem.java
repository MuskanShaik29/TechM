class Payment {
    void pay(int amount) {
        System.out.println("Paid " + amount + " using cash.");
    }

    void pay(int amount, String cardNumber) {
        System.out.println("Paid " + amount + " using card: " + cardNumber);
    }

    void pay(int amount, String upi, boolean isUPI) {
        System.out.println("Paid " + amount + " using UPI: " + upi);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.pay(1000);
        payment.pay(2000, "1234-5678-9012-3456");
        payment.pay(1500, "user@upi", true);
    }
}
