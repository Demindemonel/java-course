package threads.main;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueMain {
    public static void main(String[] args) {
        LinkedBlockingQueue<Car> queue = new LinkedBlockingQueue<>(5);
        new Thread(() -> {
            for (int i = 0; i < queue.size() + 2; i++) {
                try {
                    System.out.println("Car " + i + " was" + ((queue.offer(new Car(), 500, TimeUnit.MILLISECONDS) ? "" : "n't") + " parked."));
                    TimeUnit.MILLISECONDS.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            for (int i = 0; i < queue.size(); i++) {
                Car car = queue.poll();
                if (car != null) {
                    System.out.println("Some car left the parking.");
                } else {
                    i--;
                }
            }
        }).start();
    }
}

class Car {
}
