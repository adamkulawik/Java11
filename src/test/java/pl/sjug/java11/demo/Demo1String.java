package pl.sjug.java11.demo;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo1String {

    @Test
    public void strip() {
        String textToTrim = "\u2005    aaaa    \u2005";

        assertThat(textToTrim.trim()).isEqualTo(textToTrim);                     // Pre Java 11, FOUR-PER-EM SPACE

        assertThat(textToTrim.strip()).isEqualTo("aaaa");

        assertThat(textToTrim.stripTrailing()).isEqualTo("\u2005    aaaa");

        assertThat(textToTrim.stripLeading()).isEqualTo("aaaa    \u2005");
    }

    @Test
    public void isBlank() {
        String blankNonEmpty = "\u2005    \n\t";                                                // FOUR-PER-EM SPACE

        assertThat(blankNonEmpty.trim().isEmpty()).isFalse();                                   // Pre - Java 9

        assertThat(blankNonEmpty.codePoints().allMatch(Character::isWhitespace)).isTrue();      // Java 9

        assertThat(blankNonEmpty.isBlank()).isTrue();                                           // Java 11
    }

    // Java 11 - lazy spliterator
    @Test
    public void repeat() {
        String result = "aaa".repeat(3);
        assertThat(result).isEqualTo("aaa" + "aaa" + "aaa");
    }

    @Test
    public void lines() {
        // before Java 11
        String textToSplit = "line1\nline2\r\nline3\rline4";
        String[] splittedArray = textToSplit.split("\\r\\n|\\r|\\n");
        List<String> splittedStringOldWay = asList(splittedArray);
        assertThat(splittedStringOldWay).hasSize(4);

        // Java 11
        List<String> splittedStringNewWay = textToSplit
                .lines()
                .collect(toList());
        assertThat(splittedStringNewWay).hasSize(4);
    }
}
