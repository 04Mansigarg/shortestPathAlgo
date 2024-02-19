package org.optimalPathAlgo;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    static Location[] locations = {
            new Location(12.917063, 77.631256, 0.0, "Aman"),  // Aman
            new Location(12.911815, 77.641157, 1.5, "R1"),  // Restaurant 1
            new Location(12.911784, 77.632491, 2.5, "R2"),  // Restaurant 2
            new Location(12.913428, 77.644649, 0.0, "C1"),  // Consumer 1
            new Location(12.918052, 77.637242, 0.0, "C2")   // Consumer 2
    };

    public static void main(String[] args) {
        DeliveryOptimizer deliveryOptimizer = new DeliveryOptimizer();
        PathAndTime optimalPathAndTime = deliveryOptimizer.findOptimalPathAndTime(locations);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedTime = decimalFormat.format(optimalPathAndTime.getTime());
        System.out.println("Path " + Arrays.toString(optimalPathAndTime.getPath()) + " Time " + formattedTime);
    }

}