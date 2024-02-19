package org.optimalPathAlgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DeliveryOptimizer {

    public PathAndTime findOptimalPathAndTime(Location[] locations) {
        int n = locations.length;
        boolean[] visited = new boolean[n];
        int[] route = new int[n];
        route[0] = 0; // Starting from Aman's location

        Map<Integer, Integer> customerRestaurantMap = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (i <= 2) {
                customerRestaurantMap.put(i + 2, i);
            }
        }

        double totalTime = 0.0;

        for (int i = 1; i < n; i++) {
            int nearest = -1;
            double minTime = Double.MAX_VALUE;

            for (int j = 1; j < n; j++) {
                if (!visited[j]) {
                    double travelTime;

                    if (j <= 2) {
                        travelTime = locations[route[i - 1]].getPreparationTime()
                                + haversine(locations[route[i - 1]], locations[j])
                                + locations[j].getPreparationTime();
                    } else {
                        int correspondingRestaurant = customerRestaurantMap.get(j);
                        if (Objects.equals(route[i - 1], correspondingRestaurant)) {
                            travelTime = locations[route[i - 1]].getPreparationTime()
                                    + haversine(locations[route[i - 1]], locations[j]);
                        } else {
                            travelTime = Double.MAX_VALUE;
                        }
                    }

                    if (travelTime < minTime) {
                        minTime = travelTime;
                        nearest = j;
                    }
                }
            }

            totalTime += minTime;
            route[i] = nearest;
            visited[nearest] = true;
        }

        String[] pathWithNames = new String[n];
        for (int i = 0; i < n; i++) {
            pathWithNames[i] = locations[route[i]].getName();
        }

        return new PathAndTime(pathWithNames, totalTime);
    }

    private double haversine(Location location1, Location location2) {
        // Radius of the Earth in kilometers
        final double RADIUS = 6371.0;

        // Extract latitude and longitude values
        double lat1 = Math.toRadians(location1.getLatitude());
        double lon1 = Math.toRadians(location1.getLongitude());
        double lat2 = Math.toRadians(location2.getLatitude());
        double lon2 = Math.toRadians(location2.getLongitude());

        // Haversine formula
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        return RADIUS * c;
    }


}
