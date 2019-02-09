package pl.sjug.java11.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RepeatTest {

    private static final String NON_WHITESPACE = "aaa";

    @Test
    public void shouldRepeatNumberOfTimes() {
        // given
        var toRepeat = NON_WHITESPACE;

        // when
        var result = toRepeat.repeat(3);

        // then
        assertThat(result).isEqualTo(NON_WHITESPACE + NON_WHITESPACE + NON_WHITESPACE);
    }

    @Test
    public void shouldNotRepeatWhenNoRepetitionsOrdered() {
        // given
        var toRepeat = NON_WHITESPACE;

        // when
        var result = toRepeat.repeat(0);

        // then
        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    public void shouldNotRepeatEmptyString() {
        // given
        var toRepeat = "";

        // when
        var result = toRepeat.repeat(10);

        // then
        assertThat(result.isEmpty()).isTrue();
    }
}
