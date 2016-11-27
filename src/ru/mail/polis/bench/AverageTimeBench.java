package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nechaev Mikhail
 * Since 20/11/16.
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class AverageTimeBench {

    int[][] data;
    int[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][100];
        for (int i = 0; i < 10; i++) {
            //define arrays here
            data[i] = Helper.gen(100);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureBubbleSort() {
        BubbleSort.sort(curr);
    }
    @Benchmark
    public void measureInsertionSort() {
        InsertionSort.sort(curr);
    }
    @Benchmark
    public void measureInsertionBinSort() {
        InsertionBinSort.sort(curr);
    }
    @Benchmark
    public void measureShellSort() {
        ShellSort.sort(curr);
    }
    @Benchmark
    public void measureKStaticMSort() {
        KStatisticMSort.sort(curr);
    }
    @Benchmark
    public void measureMerge() {
        MergeSort.sort(curr);
    }
    @Benchmark
    public void measureQuickSort() {
        QuickSort.sort(curr);
    }
    @Benchmark
    public void measureQuickSortRandom() {
        QuickSortRandom.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageTimeBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}