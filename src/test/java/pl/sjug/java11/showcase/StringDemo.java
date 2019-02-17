package pl.sjug.java11.showcase;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringDemo {

    @Test
    public void isBlank() {
        var blankNonEmpty = "\u2005    \n\t";                                                   // FOUR-PER-EM SPACE
        assertThat(blankNonEmpty.trim().isEmpty()).isFalse();                                   // Pre - Java 8
        assertThat(blankNonEmpty.codePoints().allMatch(Character::isWhitespace)).isTrue();      // Java 9
        assertThat(blankNonEmpty.isBlank()).isTrue();                                           // Java 11
    }

    // Java 11 - lazy spliterator
    @Test
    public void lines() {
        // when
        var list = "aaa\naaa\naaa".lines().collect(toList());

        // then
        Assertions.assertThat(list).hasSize(3);
    }

    @Test
    public void repeat() {
        // given
        var toRepeat = "aaa";

        // when
        var result = toRepeat.repeat(3);

        // then
        Assertions.assertThat(result).isEqualTo("aaa" + "aaa" + "aaa");
    }

    @Test
    public void strip() {
        // expect
        assertThat("    aaaa    ".strip()).isEqualTo("aaaa");
    }

    @Test
    public void stripTrailing() {
        // expect
        assertThat("    aaaa    ".stripTrailing()).isEqualTo("    aaaa");
    }

    @Test
    public void stripLeading() {
        // expect
        assertThat("    aaaa    ".stripLeading()).isEqualTo("aaaa    ");
    }
}
