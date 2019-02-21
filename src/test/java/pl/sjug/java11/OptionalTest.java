package pl.sjug.java11;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {

    @Test
    public void shouldBeEmpty() {
        // given
        Optional<String> optional = Optional.empty();

        // expect
        assertThat(optional.isEmpty()).isTrue();
    }

    @Test
    public void shouldNotBeEmpty() {
        // given
        Optional<String> optional = Optional.of("text");

        // expect
        assertThat(optional.isEmpty()).isFalse();
    }

    @Test
    public void longShouldBeEmpty() {
        // given
        OptionalLong optional = OptionalLong.empty();

        // expect
        assertThat(optional.isEmpty()).isTrue();
    }

    @Test
    public void longShouldNotBeEmpty() {
        // given
        OptionalLong optional = OptionalLong.of(1L);

        // expect
        assertThat(optional.isEmpty()).isFalse();
    }

    @Test
    public void intShouldBeEmpty() {
        // given
        OptionalInt optional = OptionalInt.empty();

        // expect
        assertThat(optional.isEmpty()).isTrue();
    }

    @Test
    public void intShouldNotBeEmpty() {
        // given
        OptionalInt optional = OptionalInt.of(1);

        // expect
        assertThat(optional.isEmpty()).isFalse();
    }

    @Test
    public void doubleShouldBeEmpty() {
        // given
        OptionalDouble optional = OptionalDouble.empty();

        // expect
        assertThat(optional.isEmpty()).isTrue();
    }

    @Test
    public void doubleShouldNotBeEmpty() {
        // given
        OptionalDouble optional = OptionalDouble.of(1.0d);

        // expect
        assertThat(optional.isEmpty()).isFalse();
    }
}
