class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    void display() {
        System.out.println("Brand: " + brand);
    }
}

class Car extends Vehicle {
    int speed;

    Car(String brand, int speed) {
        super(brand);
        this.speed = speed;
    }

    void display() {
        super.display();
        System.out.println("Speed: " + speed + " km/h");
    }
}

public class VehicleInheritance {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 180);
        car.display();
    }
}
