package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatures;
    private int size;
    private static double MIN_TEMP = -273.0;
    private static int DEFAULT_SIZE = 16;

    public TemperatureSeriesAnalysis() {
        temperatures = new double[DEFAULT_SIZE];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        int i = 0;
        temperatures = new double[temperatureSeries.length];


        for (double temp : temperatureSeries) {
            if (temp < MIN_TEMP) {
                throw new InputMismatchException("Wrong temperature value!");
            } else {
                temperatures[i] = temp;
                i++;
            }
        }

        size = i;
    }

    public double average() {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double average = 0;

        for (int i = 0; i < size; i++) {
                average += temperatures[i];
            }

        average = average/size;

        return average;
    }

    public double deviation() {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double average = average();

        double avrsum = 0;
        double dev;

        for (int i = 0; i < size; i++) {
            avrsum += (temperatures[i] - average)*(temperatures[i] - average);
        }
        dev = Math.sqrt(avrsum/size);

        return dev;
    }

    public double min() {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double min = temperatures[0];

        for (double temp : temperatures) {
            if (temp < min) {
                min = temp;
            }
        }

        return min;
    }

    public double max() {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double max = temperatures[0];

        for (double temp : temperatures) {
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }

    public double findTempClosestToZero() {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double closeToZero = temperatures[0];

        for (double temp : temperatures) {
            if (Math.abs(temp) < Math.abs(closeToZero)) {
                closeToZero = temp;
            } else if ((Math.abs(temp) == Math.abs(closeToZero))
                    && (temp > closeToZero)) {
                closeToZero = temp;
            }
        }

        return closeToZero;
    }

    public double findTempClosestToValue(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double closeToZero = temperatures[0];

        for (double temp : temperatures) {
            if (Math.abs(temp - tempValue) < Math.abs(closeToZero
                    - tempValue)) {
                closeToZero = temp;
            } else if ((Math.abs(temp - tempValue) == Math.abs(closeToZero
                    - tempValue)) && (temp > closeToZero)) {
                closeToZero = temp;
            }
        }

        return closeToZero;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        int counter = 0;

        for (double temp : temperatures) {
            if (temp < tempValue) {
                counter++;
            }
        }

        double[] smallerArray = new double[counter];
        int i = 0;

        for (double temp : temperatures) {
            if (temp < tempValue) {
                smallerArray[i] = temp;
                i++;
            }
        }

        return smallerArray;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        int counter = 0;

        for (double temp : temperatures) {
            if (temp >= tempValue) {
                counter++;
            }
        }

        double[] biggerArray = new double[counter];
        int i = 0;

        for (double temp : temperatures) {
            if (temp >= tempValue) {
                biggerArray[i] = temp;
                i++;
            }
        }

        return biggerArray;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double average = average();
        double dev = deviation();
        double min = min();
        double max = max();

        return new TempSummaryStatistics(average, dev, min, max);
    }

    public int addTemps(double... temps) {
        int tempsLen = 0;

        for (double temp : temps) {
            tempsLen++;
        }
        if (temperatures.length == 0) {
            temperatures = new double[tempsLen];
            int i = 0;

            for (double temp : temps) {
                temperatures[i] = temp;
                i++;
            }

            size = tempsLen;
        } else {
            int newLen = temperatures.length;

            while (true) {
                if (size + tempsLen > newLen) {
                    newLen = newLen*2;
                } else {
                    break;
                }
            }

            if (newLen == temperatures.length) {
                for (double temp : temps) {
                    temperatures[size - 1] = temp;
                    size++;
                }
            } else {
                double[] new_temp = new double[newLen];
                System.arraycopy(this.temperatures, 0, new_temp
                        , 0, temperatures.length);
                temperatures = new_temp;
                size += tempsLen;
            }
        }
        
        return size;
    }
}
