package pl.sjug.java13.examples;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.sjug.java13.examples.SwitchTest.Quarter.Q1;
import static pl.sjug.java13.examples.SwitchTest.Quarter.Q2;
import static pl.sjug.java13.examples.SwitchTest.Quarter.Q3;
import static pl.sjug.java13.examples.SwitchTest.Quarter.Q4;
import static pl.sjug.java13.examples.SwitchTest.Quarter.UNSPECIFIED;

public class SwitchTest {

    @Test
    public void preJava13() {
        assertThat(monthToQuarterPre13(Month.JANUARY)).isEqualTo(Q1);
        assertThat(monthToQuarter12(Month.JANUARY)).isEqualTo(Q1);
        assertThat(monthToQuarter13(Month.JANUARY)).isEqualTo(Q1);
    }

    Quarter monthToQuarterPre13(Month month) {
        switch (month) {
            case JANUARY:
            case FEBRUARY:
            case MARCH:
                return Q1;
            case APRIL:
            case MAY:
            case JUNE:
                return Q2;
            case JULY:
            case AUGUST:
            case SEPTEMBER:
                return Q3;
            case OCTOBER:
            case NOVEMBER:
            case DECEMBER:
                return Q4;
        }

        return UNSPECIFIED;
    }

    Quarter monthToQuarter12(Month month) {
        switch (month) {
            case JANUARY, FEBRUARY, MARCH:
                return Q1;
            case APRIL, MAY, JUNE:
                return Q2;
            case JULY, AUGUST, SEPTEMBER:
                return Q3;
            case OCTOBER, NOVEMBER, DECEMBER:
                return Q4;
        }

        return UNSPECIFIED;
    }

    Quarter monthToQuarter13(Month month) {
        return switch (month) {
            case JANUARY, FEBRUARY, MARCH -> Q1;
            case APRIL, MAY, JUNE -> Q2;
            case JULY, AUGUST, SEPTEMBER -> Q3;
            case OCTOBER, NOVEMBER, DECEMBER -> Q4;
        };
    }

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    }

    enum Quarter {
        Q1, Q2, Q3, Q4, UNSPECIFIED;
    }
}
