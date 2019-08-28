package pl.sjug.java13.examples;

import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;

public class CollectorTeeingTest {

    public static void main(String[] args) {
        double average = Stream.of(1, 4, 2, 7, 4, 6, 5)
                               .collect(teeing(
                                       summingDouble(i -> i),
                                       counting(),
                                       (sum, n) -> sum / n));

        System.out.println(average);
    }
}
