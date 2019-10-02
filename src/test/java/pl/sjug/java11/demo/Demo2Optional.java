package pl.sjug.java11.demo;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Demo2Optional {

    @Test
    public void empty() {
        // given
        Optional<String> optional = Optional.empty();

        // expect
        assertThat(optional.isEmpty()).isTrue();
    }

    @Test
    public void notEmpty() {
        // given
        Optional<String> optional = Optional.of("text");

        // expect
        assertThat(optional.isEmpty()).isFalse();
    }
}
