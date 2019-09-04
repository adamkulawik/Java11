package pl.sjug.java13.examples;

import lombok.Value;
import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectorTeeingTest {

    @Test
    public void sumAndAverage() {
        // given
        Stream<Integer> inputStream = Stream.of(1, 2, 3, 4, 5, 6);

        // when
        Result result = inputStream
                .collect(teeing(
                        summingDouble(i -> i),
                        averagingDouble(i -> i),
                        Result::new));

        // then
        assertThat(result.avg).isEqualTo(3.5);
        assertThat(result.sum).isEqualTo(21);
    }

    @Value
    class Result {
        double sum;
        double avg;
    }
}
