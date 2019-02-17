package pl.sjug.java11.showcase;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalDemo {

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
