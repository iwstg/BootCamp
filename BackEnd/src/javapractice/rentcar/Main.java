package javapractice.rentcar;

interface Rentable{
    void rent();
}

interface Returnable{
    void returnVehicle();
}

abstract class Vehicle implements Rentable, Returnable{
    protected String brand;
    protected String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    abstract int calculateRentalFee(int Rentdays);
}


class Car extends Vehicle implements Rentable, Returnable{

    public Car(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void rent() {
        System.out.println(brand + "사 의 " + model + " 차량 대여 시작");
    }

    @Override
    public void returnVehicle() {
        System.out.println(brand + "사 의 " + model + " 차량 반납");
    }

    @Override
    int calculateRentalFee(int days) {
        return days * 50000;
    }
}

class Truck extends Vehicle implements Rentable, Returnable{

    public Truck(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void rent() {
        System.out.println(brand + "사 의 " + model + " 차량 대여 시작");
    }

    @Override
    public void returnVehicle() {
        System.out.println(brand + "사 의 " + model + " 차량 반납");
    }

    @Override
    int calculateRentalFee(int days) {
        return days * 80000;
    }
}

class ElectricCar extends Vehicle implements Rentable, Returnable{

    public ElectricCar(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void rent() {
        System.out.println(brand + "사 의 " + model + " 차량 대여 시작");
    }

    @Override
    public void returnVehicle() {
        System.out.println(brand + "사 의 " + model + " 차량 반납");
    }

    @Override
    int calculateRentalFee(int days) {
        System.out.println("전기차 충전비가 추가됩니다.");
        return days * 70000;
    }
}


public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("Hyundai", "Sonata"),
                new Truck("Kia", "Bongo"),
                new ElectricCar("Tesla", "Model 3")
        };

        for(Vehicle v : vehicles){
            v.rent(); // 대여 시작
            v.returnVehicle(); // 반납 완료
            System.out.printf("%,d원 %n", v.calculateRentalFee(6)); // 6일 대여 시 가격
        }
    }
}
