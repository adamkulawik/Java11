package pl.sjug.java11.demo;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo5Pattern {
    @Test
    public void shouldAsPredicate() {
        // given
        Predicate<String> stringPredicate = Pattern.compile("[a-z]*").asPredicate();

        List<String> strings = asList("a", "ab", "ab1A", "A123aa");

        // when
        List<String> result = strings.stream().filter(stringPredicate).collect(toList());

        // then
        assertThat(result).containsExactlyInAnyOrder("a", "ab", "ab1A", "A123aa");
    }

    @Test
    public void shouldAsMatchPredicate() {
        // given
        Predicate<String> stringPredicate = Pattern.compile("[a-z]*").asMatchPredicate();

        List<String> strings = asList("a", "ab", "ab1A", "A123aa");

        // when
        List<String> result = strings.stream().filter(stringPredicate).collect(toList());

        // then
        assertThat(result).containsExactlyInAnyOrder("a", "ab");
    }

}
