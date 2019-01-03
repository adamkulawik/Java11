package pl.sjug.java11;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeUnitTest {

    @Test
    public void shouldConvertDaysToHours() {
        // given
        var duration = Duration.ofDays(1);

        var timeUnit = TimeUnit.HOURS;

        // when
        var convert = timeUnit.convert(duration);

        // then
        assertThat(convert).isEqualTo(24);
    }

    @Test
    public void shouldConvertMinutesToHours() {
        // given
        var duration = Duration.ofMinutes(119);

        var timeUnit = TimeUnit.HOURS;

        // when
        var convert = timeUnit.convert(duration);

        // then
        assertThat(convert).isEqualTo(1);
    }

    @Test
    public void shouldConvertHoursToDays() {
        // given
        var duration = Duration.ofHours(24);

        var timeUnit = TimeUnit.DAYS;

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
