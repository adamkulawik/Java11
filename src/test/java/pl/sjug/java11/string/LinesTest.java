package pl.sjug.java11.string;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

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
}
