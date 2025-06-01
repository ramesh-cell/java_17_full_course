package test.demov1.carrier_test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TemperatureSensor {
    private static final Random random = new Random();

    public static int readTemperature() {
        return 20 + random.nextInt(10); // Simulates temp between 20-30°C
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule sensor reading every 5 seconds
        scheduler.scheduleAtFixedRate(() -> {
            int temp = readTemperature();
            System.out.println("Current Temperature: " + temp + "°C");
        }, 0, 5, TimeUnit.SECONDS);
    }
}
