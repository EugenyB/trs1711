package main;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

/**
 * Created by eugeny on 17.11.2016.
 */
public class IntegralCalculator {
    double a;
    double b;
    int n;
    DoubleUnaryOperator f;

    public IntegralCalculator(double a, double b, int n, DoubleUnaryOperator f) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }

    public double calc() {
        double h = (b-a)/n;
        return IntStream.range(0, n)
                .mapToDouble(i -> a + i * h)
                .map(f)
                .sum() * h;
    }
}
