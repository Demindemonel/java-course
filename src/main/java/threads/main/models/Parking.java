package threads.main.models;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Parking {
    private LinkedBlockingQueue<Car> cars;
    private int parkingPlacesCount;

    public Parking(int parkingPlacesCount) {
        this.parkingPlacesCount = parkingPlacesCount;
        this.cars = new LinkedBlockingQueue<>(parkingPlacesCount);
    }

    public int getParkingPlacesCount() {
        return parkingPlacesCount;
    }

    public synchronized void add(Car car) {
        try {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + car.getName() + " waited " + car.getWaitingForParking() + " MILLISECONDS and " + (cars.offer(car, car.getWaitingForParking(), TimeUnit.MILLISECONDS) ? "parked." : "drove away."));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized boolean remove() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Car car = cars.poll();
        System.out.println(Thread.currentThread().getName() + ": " + (car == null ? "Parking is empty." : car.getName() + " left the parking."));
        return car != null;
    }
}
