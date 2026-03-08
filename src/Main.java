// 4 Pilar OOP: Encapsulation, Inheritance, Polymorphism, Abstraction

public class Main {
    public static void main(String[] args) {

        // Polymorphism: constructor overloading
        Car myCar   = new Car();
        Car myHonda = new Car("Honda", "Yellow", "Brio", 100);

        System.out.println("Brand : " + myHonda.getBrand());
        System.out.println("Speed : " + myHonda.getSpeed() + " km/h");

        myHonda.accelerate(30);
        myHonda.brake(20);
        myHonda.info();

        // Inheritance: ElectricCar turunan dari Car
        ElectricCar myTesla = new ElectricCar("Tesla", "White", "Model 3", 120, 80);
        myTesla.charge(10);
        myTesla.info(); // Polymorphism: info() berbeda dari Car
    }
}


// Parent class
class Car {

    // Encapsulation: atribut private, hanya bisa diakses lewat getter/setter
    private String brand;
    private String color;
    private String type;
    private int speed;

    public Car() {
        this.brand = "Unknown";
        this.color = "Unknown";
        this.type  = "Unknown";
        this.speed = 0;
    }

    // Polymorphism: constructor overloading
    public Car(String brand, String color, String type, int speed) {
        this.brand = brand;
        this.color = color;
        this.type  = type;
        this.speed = speed;
    }

    public void accelerate(int amount) {
        this.speed += amount;
        System.out.println(brand + " accelerates! Speed: " + speed + " km/h");
    }

    public void brake(int amount) {
        this.speed = Math.max(0, this.speed - amount);
        System.out.println(brand + " brakes! Speed: " + speed + " km/h");
    }

    // Polymorphism: method ini bisa di-override oleh class anak
    public void info() {
        System.out.println("[Car] " + brand + " " + type + " | " + color + " | " + speed + " km/h");
    }

    // Getter & Setter (Encapsulation)
    public String getBrand() { return brand; }
    public String getColor() { return color; }
    public String getType()  { return type; }
    public int    getSpeed() { return speed; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setColor(String color) { this.color = color; }
    public void setType(String type)   { this.type = type; }
    public void setSpeed(int speed)    { if (speed >= 0) this.speed = speed; }
}


// Inheritance: ElectricCar mewarisi semua atribut & method dari Car
class ElectricCar extends Car {

    private int batteryLevel;

    public ElectricCar(String brand, String color, String type, int speed, int batteryLevel) {
        super(brand, color, type, speed); // panggil constructor parent
        this.batteryLevel = batteryLevel;
    }

    public void charge(int amount) {
        this.batteryLevel = Math.min(100, this.batteryLevel + amount);
        System.out.println(getBrand() + " charging... Battery: " + batteryLevel + "%");
    }

    // Polymorphism: override info() dari parent
    @Override
    public void info() {
        System.out.println("[ElectricCar] " + getBrand() + " " + getType()
            + " | " + getColor() + " | " + getSpeed() + " km/h"
            + " | Battery: " + batteryLevel + "%");
    }

    public int  getBatteryLevel()          { return batteryLevel; }
    public void setBatteryLevel(int level) { if (level >= 0 && level <= 100) this.batteryLevel = level; }
}


// Abstraction: kerangka umum kendaraan tanpa detail implementasi
abstract class Vehicle {

    private String brand;

    public Vehicle(String brand) { this.brand = brand; }

    // Abstract method: wajib diisi oleh class turunan
    public abstract void fuelType();

    public String getBrand() { return brand; }
}

// Contoh implementasi abstract class
class Motorcycle extends Vehicle {

    public Motorcycle(String brand) { super(brand); }

    @Override
    public void fuelType() {
        System.out.println(getBrand() + " uses gasoline.");
    }
}