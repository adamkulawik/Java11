package pl.sjug.java11.string;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class RepeatTest {

    private static final String LINE_ENDING = "\n";
    private static final String NON_WHITESPACE = "aaa";

    @Test
    public void shouldGetLines() {
        // given
        var text = NON_WHITESPACE + LINE_ENDING + NON_WHITESPACE + LINE_ENDING + NON_WHITESPACE + LINE_ENDING;

        // when
        var list = text.lines().collect(toList());

        // then
        assertThat(list).hasSize(3).contains(NON_WHITESPACE);
    }

    @Test
    public void shouldRepeat() {
        // given
        var toRepeat = NON_WHITESPACE;

        // when
        var result = toRepeat.repeat(3);

        // then
        assertThat(result).isEqualTo(NON_WHITESPACE + NON_WHITESPACE + NON_WHITESPACE);
    }

    @Test
    public void shouldNotRepeat() {
        // given
        var toRepeat = NON_WHITESPACE;

        // when
        var result = toRepeat.repeat(0);

        // then
        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    public void shouldNotRepeatEmptyStrint() {
        // given
        var toRepeat = "";

        // when
        var result = toRepeat.repeat(10);

        // then
        assertThat(result.isEmpty()).isTrue();
    }


}
