package org.optimalPathAlgo;

import java.util.Objects;

public class Location {
    private Double latitude;
    private Double longitude;
    private Double preparationTime; // if location is for restaurant then time in hours, otherwise 0 ;
    private String name;

    public Location(Double latitude, Double longitude, Double preparationTime, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.preparationTime = preparationTime;
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getPreparationTime() {
        return preparationTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(latitude, location.latitude)
                && Objects.equals(longitude, location.longitude)
                && Objects.equals(preparationTime, location.preparationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, preparationTime);
    }
}
