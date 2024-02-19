package org.optimalPathAlgo;

public class PathAndTime {

    private String[] path;
    private Double time;

    public PathAndTime(String[] path, Double time) {
        this.path = path;
        this.time = time;
    }

    public String[] getPath() {
        return path;
    }

    public Double getTime() {
        return time;
    }
}
