package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.LSDSort;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 27.11.2016.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LSDSortBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        //a = Helper.gen(1000);
        a = new int[]{10, 31, 27, 12, 11, 74};
    }

    @Benchmark
    public void measureLSD(Blackhole bh) {
        bh.consume(LSDSort.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LSDSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
