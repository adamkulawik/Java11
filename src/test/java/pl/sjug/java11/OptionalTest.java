package pl.sjug.java11;

import java.util.Optional;

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
}
