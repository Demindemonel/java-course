package threads.main;

import threads.main.models.Parking;
import threads.main.tasks.CarGenerator;
import threads.main.tasks.CarRemover;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParkingWithExecutorServiceMain {
    public static void main(String[] args) {
        Parking parking = new Parking(3);
        CarGenerator carGenerator = new CarGenerator(parking, 10);
        CarRemover carRemover = new CarRemover(parking, 3);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(carGenerator);
        executorService.execute(carRemover);

        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }
}
