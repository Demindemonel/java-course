package threads.main.tasks;

import threads.main.models.Parking;

import java.util.concurrent.TimeUnit;

public class CarRemover implements Runnable {
    private Parking parking;
    private int carsToRemoveCount;

    public CarRemover(Parking parking, int carsToRemoveCount) {
        this.parking = parking;
        this.carsToRemoveCount = carsToRemoveCount;
    }

    @Override
    public void run() {
        while (carsToRemoveCount != 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (parking.remove()) carsToRemoveCount--;

        }
    }
}
