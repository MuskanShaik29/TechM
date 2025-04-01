abstract class Shopping {
    abstract void payment();
}

class OnlineShopping extends Shopping {
    void payment() {
        System.out.println("Payment completed online.");
    }
}

public class ShoppingSystem {
    public static void main(String[] args) {
        Shopping shop = new OnlineShopping();
        shop.payment();
    }
}
