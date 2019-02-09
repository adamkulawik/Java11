package pl.sjug.java11.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class IsBlankTest {

    @Test
    public void shouldBeBlankButIsNotEmpty() {
        var blankNonEmpty = "\u2005    \n\t";
        assertThat(blankNonEmpty.isBlank()).isTrue();           // Java 11
        assertThat(blankNonEmpty.trim().isEmpty()).isFalse();   // Pre - Java 8
        assertThat(blankNonEmpty.codePoints().allMatch(Character::isWhitespace)).isTrue();   // Java 8

    }

   @Test
    public void shouldBeBlankAndEmpty() {
        var blankNonEmpty = "";
        assertThat(blankNonEmpty.isBlank()).isTrue();           // Java 11
        assertThat(blankNonEmpty.isEmpty()).isTrue();           // Pre - Java 11
    }

    @Test
    public void shouldBeNeitherBlankNotEmpty() {
        var notBlankNorEmpty = "aaa";
        assertThat(notBlankNorEmpty.isBlank()).isFalse();       // Java 11
        assertThat(notBlankNorEmpty.isEmpty()).isFalse();       // Pre - Java 11
    }
}
