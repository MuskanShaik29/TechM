class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void comparePrice(Product otherProduct) {
        if (this.price < otherProduct.price) {
            System.out.println(this.name + " is cheaper than " + otherProduct.name);
        } else if (this.price > otherProduct.price) {
            System.out.println(this.name + " is more expensive than " + otherProduct.name);
        } else {
            System.out.println(this.name + " and " + otherProduct.name + " have the same price.");
        }
    }
}

public class ProductComparison {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Tablet", 30000);
        
        p1.comparePrice(p2);
    }
}
