package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Math.PI;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        double a = 0;
        double b = PI;
        int n = 1_000_000;
        int nThreads = 400;
        double delta = (b-a)/nThreads;
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future<Double>> futures = new ArrayList<>(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Future<Double> f = es.submit(new CallableCalc(a + i * delta, a + (i + 1) * delta, n / nThreads, Math::sin));
            futures.add(f);
        }
        es.shutdown();

        double sum = 0;
        try {
            for (Future<Double> future : futures) {
                sum += future.get();
            }
            System.out.println("sum = " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
