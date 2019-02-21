package pl.sjug.java11.demo;

import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class Demo6TimeUnit {

    @Test
    public void conversion() {
        // given
        Duration oneDay = Duration.ofDays(1);

        TimeUnit timeUnit = TimeUnit.HOURS;

        // when
        long oneDayToHours = timeUnit.convert(oneDay);

        // then
        assertThat(oneDayToHours).isEqualTo(24);
    }

    @Test
    public void conversionRoundDown() {
        // given
        Duration tenMinutes = Duration.ofMinutes(10);

        TimeUnit timeUnit = TimeUnit.HOURS;

        // when
        long tenMinutesToHours = timeUnit.convert(tenMinutes);

        // then
        assertThat(tenMinutesToHours).isEqualTo(0);
    }

    @Test
    public void shouldConvertHoursToHours() {
        // given
        Duration twentyFourHours = Duration.ofHours(24);

        TimeUnit timeUnit = TimeUnit.HOURS;

        // when
        long twentyFourHoursAsHours = timeUnit.convert(twentyFourHours);

        // then
        assertThat(twentyFourHoursAsHours).isEqualTo(24);
    }
}
