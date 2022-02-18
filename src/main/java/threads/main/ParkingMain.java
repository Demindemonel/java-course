package threads.main;

import threads.main.model.Car;
import threads.main.model.Parking;

public class ParkingMain {
    public static void main(String[] args) {
        Parking parking = new Parking(3);

        for (int i = 0; i < parking.getParkingPlacesCount() + 4; i++) {
            int finalI = i;
            new Thread(() -> parking.add(new Car("Car_" + finalI, 1000))).start();
        }
    }
}
