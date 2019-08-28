package pl.sjug.java13.examples;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectorTeeingTest {


    @Test
    public void collectorTeeing() {
        // given
        Stream<Integer> inputStream = Stream.of(1, 2, 3, 4, 5, 6);

        // when
        double result = inputStream
                .collect(teeing(
                        summingDouble(i -> i),
                        counting(),
                        (sum, n) -> sum / n));

        // then
        assertThat(result).isEqualTo(3.5);
    }
}
