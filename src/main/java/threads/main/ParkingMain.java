package threads.main;

import threads.main.models.Car;
import threads.main.models.Parking;

public class ParkingMain {
    public static void main(String[] args) {
        Parking parking = new Parking(5);

        for (int i = 0; i < parking.getParkingPlacesCount() + 3; i++) {
            int finalI = i;
            new Thread(() -> parking.add(new Car("Car_" + finalI, 1000))).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(parking::remove).start();
        }
    }
}
