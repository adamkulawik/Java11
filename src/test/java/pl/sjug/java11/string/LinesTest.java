package pl.sjug.java11.string;

import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.StringReader;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    private static final String LINE_ENDING = "\n";
    private static final String NON_WHITESPACE = "aaa";

    private final String text = NON_WHITESPACE + LINE_ENDING + NON_WHITESPACE + LINE_ENDING + NON_WHITESPACE + LINE_ENDING;

    // Pre Java 11 - one of at least possibilites
    @Test
    public void shouldSplit() {
        // given
        var lines = List.of(text.split("\n")).stream();

        // when
        var list = lines.collect(toList());

        // then
        assertThat(list).hasSize(3).contains(NON_WHITESPACE);
    }

    // Java 11 - lazy spliterator
    @Test
    public void shouldGetLines() {
        // when
        var list = text.lines().collect(toList());

        // then
        assertThat(list).hasSize(3).contains(NON_WHITESPACE);
    }
}
