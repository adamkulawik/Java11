package pl.sjug.java12.demo;

import lombok.Value;
import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo1Collector {

    @Test
    public void sumAndAverage() {
        Result result = Stream.of(1, 2, 3, 4, 5, 6)
                               .collect(teeing(
                                       summingDouble(number -> number),
                                       averagingDouble(number -> number),
                                       Result::new));

        assertThat(result.avg).isEqualTo(3.5);
        assertThat(result.sum).isEqualTo(21);
    }

    @Value
    class Result {
        double sum;
        double avg;
    }
}
