package threads.main.model;

public class Car {
    private String name;
    private int waitingForParking;

    public Car(String name, int waitingForParking) {
        this.name = name;
        this.waitingForParking = waitingForParking;
    }

    public String getName() {
        return name;
    }

    public int getWaitingForParking() {
        return waitingForParking;
    }
}
