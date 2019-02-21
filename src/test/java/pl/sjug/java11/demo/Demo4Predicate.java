package pl.sjug.java11.demo;

import org.junit.Test;

import java.util.function.Predicate;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo4Predicate {

    // Java 11 way - unwrapped lambda
    @Test
    public void shouldNotPredicate() {
        // expect
        assertThat(not(String::isEmpty).test("")).isFalse();
    }

    // Pre Java 11 way - explicit predicate
    @Test
    public void shouldNegatePredicate() {
        // expect
        assertThat(((Predicate<String>)String::isEmpty).negate().test("")).isFalse();
    }
}
