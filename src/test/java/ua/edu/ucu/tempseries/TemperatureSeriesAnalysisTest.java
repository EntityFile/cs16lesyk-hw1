package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.graalvm.compiler.lir.LIRInstruction;
import org.junit.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test(expected = InputMismatchException.class)
    public void testTooSmallTemp() {
        double[] temperatureSeries = {14.0, -300.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoAtribute() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testDevWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDevWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDev() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = Math.sqrt(14);

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testPositiveMin() {
        double[] temperatureSeries = {3.0, 7.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testNegativeMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testPositiveMax() {
        double[] temperatureSeries = {3.0, 7.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 7.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testNegativeMax() {
        double[] temperatureSeries = {-3.0, -5.0, -1.0, -7.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZeroWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testPositiveClosestToZero() {
        double[] temperatureSeries = {3.0, 7.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testNegativeClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, -1.0, 7.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSameClosestToZero() {
        double[] temperatureSeries = {3.0, 1.0, -1.0, 7.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        double value = 10;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(value);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        double value = 10;

        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(value);
    }

    @Test
    public void testPositiveClosestToValue() {
        double[] temperatureSeries = {3.0, 7.0, 1.0, 5.0};
        double value = 8;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 7.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(value);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testNegativeClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, -1.0, 7.0};
        double value = -4.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(value);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSameClosestToValue() {
        double[] temperatureSeries = {3.0, 5.0, -1.0, 7.0};
        double value = 6.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 7.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(value);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessWithOneElementArray1() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        double tempValue = 10.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessWithOneElementArray2() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        double tempValue = -10.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTempsLessWithEmptyArray() {
        double[] temperatureSeries = {};
        double tempValue = 10.0;

        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsLessThen(tempValue);
    }

    @Test
    public void testTempsLess() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 2.0, 5.0, 8.0};
        double tempValue = 7.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0, 2.0, 5.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessWithNegativeArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, -3.0, -7.0, -10.0};
        double tempValue = -3.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-7.0, -10.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterWithOneElementArray1() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        double tempValue = 10.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterWithOneElementArray2() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        double tempValue = -10.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTempsGreaterWithEmptyArray() {
        double[] temperatureSeries = {};
        double tempValue = 10.0;

        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsGreaterThen(tempValue);
    }

    @Test
    public void testTempsGreater() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 2.0, 5.0, 8.0};
        double tempValue = 3.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {5.0, 8.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterWithNegativeArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, -3.0, -7.0, -10.0};
        double tempValue = -7.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0, -3.0, -7.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(-1.0, 0.0, -1.0, -1.0);

        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        // compare expected result with actual result
        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 3.0, -7.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(0.0, Math.sqrt(84.0/4), -7.0, 5.0);

        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        // compare expected result with actual result
        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {-3.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] temps = {1.0, 2.0};
        int expResult = 4;
        int actualResult  = seriesAnalysis.addTemps(temps);

        // expect exception here
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTempsWithEmptyTemps() {
        double[] temperatureSeries = {1.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 2;
        int actualResult  = seriesAnalysis.addTemps();

        // expect exception here
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTempsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] temps = {1.0, 2.0};
        int expResult = 2;
        int actualResult  = seriesAnalysis.addTemps(temps);

        // expect exception here
        assertEquals(expResult, actualResult);
    }
}
