package pl.sjug.java11.demo;

import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class Demo6TimeUnit {

    // TODO: 04/10/2019 pre-11 - overflow problem

    @Test
    public void conversion() {
        // given
        Duration oneDay = Duration.ofDays(1);

        // when
        long oneDayToHours = TimeUnit.HOURS.convert(oneDay);

        // then
        assertThat(oneDayToHours).isEqualTo(24);
    }

    @Test
    public void conversionRoundDown() {
        // given
        Duration tenMinutes = Duration.ofMinutes(10);

        // when
        long tenMinutesToHours = TimeUnit.HOURS.convert(tenMinutes);

        // then
        assertThat(tenMinutesToHours).isEqualTo(0);
    }

    @Test
    public void conversionHoursToHours() {
        // given
        Duration twentyFourHours = Duration.ofHours(24);

        // when
        long twentyFourHoursAsHours = TimeUnit.HOURS.convert(twentyFourHours);

        // then
        assertThat(twentyFourHoursAsHours).isEqualTo(24);
    }
}
