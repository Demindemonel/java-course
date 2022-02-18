package threads.main;

import threads.main.model.Parking;
import threads.main.service.CarGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParkingWithExecutorServiceMain {
    public static void main(String[] args) {
        Parking parking = new Parking(3);
        CarGenerator carGenerator = new CarGenerator(parking, 7);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(carGenerator);
        executorService.shutdown();
    }
}
