package main;

import java.util.concurrent.Callable;
import java.util.function.DoubleUnaryOperator;

/**
 * Created by eugeny on 17.11.2016.
 */
public class CallableCalc implements Callable<Double> {
    private IntegralCalculator calculator;

    public CallableCalc(double a, double b, int n, DoubleUnaryOperator f) {
        this.calculator = new IntegralCalculator(a,b,n,f);
    }

    @Override
    public Double call() throws Exception {
        return calculator.calc();
    }
}
