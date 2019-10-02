package pl.sjug.java11.demo;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo3Predicate {

    // Pre Java 11 way - explicit predicate
    @Test
    public void negatePredicate() {
        Stream<String> stream = Stream.of("", "a", "b");

        List<String> result = stream.filter(((Predicate<String>) String::isBlank).negate())
                                    .collect(toList());

        assertThat(result).containsExactly("a", "b");
    }

    // Java 11 way - unwrapped lambda
    @Test
    public void notPredicate() {
        Stream<String> stream = Stream.of("", "a", "b");

        List<String> result = stream.filter(not(String::isBlank))
                                    .collect(toList());

        assertThat(result).containsExactly("a", "b");
    }
}
