OOP (Object-Oriented Programming) adalah pendekatan pemrograman yang mengorganisir kode dalam bentuk "objek". Objek adalah representasi dari sesuatu di dunia nyata — misalnya Car, Person, BankAccount. Setiap objek punya atribut (data) dan method (perilaku).


1. Encapsulation

Menyembunyikan data di dalam class supaya tidak bisa diutak-atik sembarangan dari luar. Atribut dibuat private, akses hanya boleh lewat getter/setter.

```java
private String brand; // tidak bisa diakses langsung dari luar

public String getBrand() { return brand; } // harus lewat sini
```
Tujuan: Melindungi data dari perubahan yang tidak diinginkan, Mengontrol bagaimana data diakses atau dimodifikasi.



2. Inheritance

Class anak mewarisi atribut dan method dari class induk. Tidak perlu nulis ulang kode yang sama.

```java
class ElectricCar extends Car {
    // otomatis punya brand, speed, accelerate(), dll dari Car
    private int batteryLevel; // tinggal tambah atribut baru
}
```
Tujuan: Mengurangi duplikasi kode, Mempermudah pengembangan sistem.


3. Polymorphism

Satu nama, banyak bentuk. Ada dua jenisnya, overloading (method/constructor nama sama tapi parameter beda) dan overriding (method di class anak menimpa method yang sama dari class induk).

```java
// Overloading: dua constructor, nama sama, parameter beda
public Car() { ... }
public Car(String brand, String color, ...) { ... }

// Overriding: ElectricCar punya versi info() sendiri
@Override
public void info() {
    System.out.println("[ElectricCar] ...");
}
```


4. Abstraction

Menyembunyikan detail implementasi, hanya menampilkan fungsi yang perlu diketahui pengguna. Pakai abstract class atau interface.

```java
abstract class Vehicle {
    public abstract void fuelType(); // wajib diisi class turunan
}

class Motorcycle extends Vehicle {
    @Override
    public void fuelType() {
        System.out.println("Uses gasoline.");
    }
}
```

