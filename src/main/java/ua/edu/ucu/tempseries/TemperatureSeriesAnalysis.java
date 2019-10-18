package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatures;
    private int size;

    public TemperatureSeriesAnalysis() {
        temperatures = new double[16];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        int i = 0;
        temperatures = new double[temperatureSeries.length];

        for (double temp : temperatureSeries) {
            if (temp < -273) {
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

        double close_to_zero = temperatures[0];

        for (double temp : temperatures) {
            if (Math.abs(temp) < Math.abs(close_to_zero)) {
                close_to_zero = temp;
            } else if ((Math.abs(temp) == Math.abs(close_to_zero)) && (temp > close_to_zero)){
                close_to_zero = temp;
            }
        }

        return close_to_zero;
    }

    public double findTempClosestToValue(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException("Temperatures array is empty!");
        }

        double close_to_zero = temperatures[0];

        for (double temp : temperatures) {
            if (Math.abs(temp - tempValue) < Math.abs(close_to_zero - tempValue)) {
                close_to_zero = temp;
            } else if ((Math.abs(temp - tempValue) == Math.abs(close_to_zero - tempValue)) && (temp > close_to_zero)){
                close_to_zero = temp;
            }
        }

        return close_to_zero;
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

        double[] smaller_array = new double[counter];
        int i = 0;

        for (double temp : temperatures) {
            if (temp < tempValue) {
                smaller_array[i] = temp;
                i++;
            }
        }

        return smaller_array;
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

        double[] bigger_array = new double[counter];
        int i = 0;

        for (double temp : temperatures) {
            if (temp >= tempValue) {
                bigger_array[i] = temp;
                i++;
            }
        }

        return bigger_array;
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
        int temps_len = 0;

        for (double temp : temps) {
            temps_len++;
        }
        if (temperatures.length == 0) {
            temperatures = new double[temps_len];
            int i = 0;

            for (double temp : temps) {
                temperatures[0] = temp;
                i++;
            }

            size = temps_len;
        } else {
            int newLen = temperatures.length;

            while (true) {
                if (size + temps_len > newLen) {
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
                System.arraycopy(this.temperatures, 0, new_temp, 0, temperatures.length);
                temperatures = new_temp;
                size += temps_len;
            }
        }

        for (double temp : temperatures) {
            System.out.println(size);
        }
        return size;
    }
}
