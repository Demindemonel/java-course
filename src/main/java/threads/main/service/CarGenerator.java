package threads.main.service;

import threads.main.model.Car;
import threads.main.model.Parking;

public class CarGenerator implements Runnable {
    private Parking parking;
    private int carsCount;

    public CarGenerator(Parking parking, int carsCount) {
        this.parking = parking;
        this.carsCount = carsCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < carsCount; i++) {
            parking.add(new Car("Car " + i, 1000));
        }
    }
}
