package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(double average, double dev, double min, double max) {
        this.avgTemp = average;
        this.devTemp = dev;
        this.minTemp = min;
        this.maxTemp = max;
    }

    public double getAvgTemp() {
        return this.avgTemp;
    }

    public double getDevTemp() {
        return this.devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
