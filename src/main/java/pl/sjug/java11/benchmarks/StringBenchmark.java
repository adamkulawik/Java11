package pl.sjug.java11.benchmarks;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G", "--enable-preview", "-verbose:gc"})
public class StringBenchmark {

    @Param({"1000"})
    private int N;

    private String DATA_FOR_TESTING = "";

    private String toRepeat = RandomStringUtils.randomAlphanumeric(10);

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(StringBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        for (int i = 0; i < N; i++) {
            DATA_FOR_TESTING += RandomStringUtils.randomAlphanumeric(100) +"\n";
        }

        System.out.println("data ready");

    }

    @Benchmark
    public void linesOld() {
        String textToSplit = DATA_FOR_TESTING;
        String[] splittedArray = textToSplit.split("\\r\\n|\\r|\\n");
        List<String> splittedStringOldWay = asList(splittedArray);
    }

    @Benchmark
    public void linesNew() {
        DATA_FOR_TESTING.lines().collect(Collectors.toList());
    }

    @Benchmark
    public void repeatNew() {
        toRepeat.repeat(10000);
    }

    @Benchmark
    public void repeatBuilder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append(toRepeat);
        }

        builder.toString();
    }

    @Benchmark
    public void repeatLoop() {
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += toRepeat;
        }
    }
}
