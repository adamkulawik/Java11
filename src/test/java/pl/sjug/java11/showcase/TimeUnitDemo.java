package pl.sjug.java11.showcase;

import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeUnitDemo {

    @Test
    public void conversion() {
        // given
        var duration = Duration.ofDays(1);

        var timeUnit = TimeUnit.HOURS;

        // when
        var convert = timeUnit.convert(duration);

        // then
        assertThat(convert).isEqualTo(24);
    }

    @Test
    public void conversionRoundDown() {
        // given
        var duration = Duration.ofMinutes(119);

        var timeUnit = TimeUnit.HOURS;

        // when
        var convert = timeUnit.convert(duration);

        // then
        assertThat(convert).isEqualTo(1);
    }

    @Test
    public void shouldConvertHoursToHours() {
        // given
        var duration = Duration.ofHours(24);

        var timeUnit = TimeUnit.HOURS;

        // when
        var convert = timeUnit.convert(duration);

        // then
        assertThat(convert).isEqualTo(24);
    }
}
