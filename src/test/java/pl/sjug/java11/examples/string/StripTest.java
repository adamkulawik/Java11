package pl.sjug.java11.examples.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StripTest {

    private static final String WHITESPACES = "\n\t     \u2005";    // FOUR-PER-EM SPACE - whitespace in Unicode, 1/4 width of space
    private static final String NON_WHITESPACE = "aaa";

    @Test
    public void shouldStripStringContaingWhitespaces() {
        // given
        var toStrip = WHITESPACES + NON_WHITESPACE + WHITESPACES;

        // when
        var result = toStrip.strip();

        // then
        assertThat(result).isEqualTo(NON_WHITESPACE);
    }

    @Test
    public void shouldStripLeadingInStringContaingWhitespaces() {
        // given
        var toStrip = WHITESPACES + NON_WHITESPACE + WHITESPACES;

        // when
        var result = toStrip.stripLeading();

        // then
        assertThat(result).isEqualTo(NON_WHITESPACE + WHITESPACES);
    }

    @Test
    public void shouldstripTrailingInStringContaingWhitespaces() {
        // given
        var toStrip = WHITESPACES + NON_WHITESPACE + WHITESPACES;

        // when
        var result = toStrip.stripTrailing();

        // then
        assertThat(result).isEqualTo(WHITESPACES + NON_WHITESPACE);
    }

    @Test
    public void shouldStripOnlyWhitespaces() {
        // when
        var stripped = WHITESPACES.strip();

        // then
        assertThat(stripped).isEmpty();
    }

    @Test
    public void shouldNotRemoveWhiteSpaceFromMiddle() {
        // given
        var toStrip = NON_WHITESPACE + WHITESPACES + NON_WHITESPACE;

        // when
        var stripped = toStrip.strip();

        // then
        assertThat(stripped).isEqualTo(toStrip);
    }

    @Test
    public void trimAndStripShouldDiffer() {
        // expect
        assertThat(WHITESPACES.isEmpty()).isFalse();            // Pre - Java 11
        assertThat(WHITESPACES.trim().isEmpty()).isFalse();     // Pre - Java 11
        assertThat(WHITESPACES.strip().isEmpty()).isTrue();     // Java 11
    }
}
