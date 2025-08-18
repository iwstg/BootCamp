package javastudy.parkingex;

class Vehicle{
    private final String name;
    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Car extends Vehicle{
    public Car(String name) {
        super(name);
    }
}

class Bike extends Vehicle{
    public Bike(String name) {
        super(name);
    }
}

interface Parkable<T extends Vehicle> {
    void park(T vehicle);
    T getVehicle();
}

class ParkingLot<T extends Vehicle> implements Parkable<T>{
    private T vehicle;

    @Override
    public void park(T vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("주차할 차량이 없습니다.");
        this.vehicle = vehicle;
        System.out.println(vehicle.getName() + " 주차완료");
    }

    @Override
    public T getVehicle() {
        return null;
    }
}

class ParkingUtils{
    public static <T extends Vehicle> void printParkingInfo(ParkingLot<T> lot){
        T v = lot.getVehicle();
        if(v != null){

        }

    }
}


public class Main {
    public static void main(String[] args) {
        // 자동차
        ParkingLot<Car> carLot = new ParkingLot<>();
        carLot.park(new Car("테슬라"));

        // 오토바이
        ParkingLot<Bike> bikeLot = new ParkingLot<>();
        bikeLot.park(new Bike("야마하"));

        ParkingUtils.printParkingInfo(carLot);
        ParkingUtils.printParkingInfo(bikeLot);

        ParkingLot<Car> text = new ParkingLot<>();
    }
}
