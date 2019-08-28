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
        assertThat(monthToQuarterStatement(Month.JANUARY)).isEqualTo(Q1);
        assertThat(monthToQuarterMultiValueStatement(Month.JANUARY)).isEqualTo(Q1);
        assertThat(monthToQuarterExpression(Month.JANUARY)).isEqualTo(Q1);
        assertThat(monthToQuarterExpressionYield(Month.JANUARY)).isEqualTo(Q1);
    }

    Quarter monthToQuarterStatement(Month month) {
        Quarter quarter;
        switch (month) {
            case JANUARY:
            case FEBRUARY:
            case MARCH:
                quarter = Q1;
                break;
            case APRIL:
            case MAY:
            case JUNE:
                quarter = Q2;
                break;
            case JULY:
            case AUGUST:
            case SEPTEMBER:
                quarter = Q3;
                break;
            case OCTOBER:
            case NOVEMBER:
            case DECEMBER:
                quarter = Q4;
                break;
            default:
                quarter = UNSPECIFIED;
        }

        return quarter;
    }

    Quarter monthToQuarterMultiValueStatement(Month month) {
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

    Quarter monthToQuarterExpression(Month month) {
        return switch (month) {
            case JANUARY, FEBRUARY, MARCH -> Q1;
            case APRIL, MAY, JUNE -> Q2;
            case JULY, AUGUST, SEPTEMBER -> Q3;
            case OCTOBER, NOVEMBER, DECEMBER -> Q4;
        };
    }

    Quarter monthToQuarterExpressionYield(Month month) {
        return switch (month) {
            case JANUARY, FEBRUARY, MARCH: yield Q1;
            case APRIL, MAY, JUNE: yield Q2;
            case JULY, AUGUST, SEPTEMBER: yield Q3;
            case OCTOBER, NOVEMBER, DECEMBER: yield Q4;
        };
    }

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    }

    enum Quarter {
        Q1, Q2, Q3, Q4, UNSPECIFIED;
    }
}
