package pl.sjug.java11.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class IsBlankTest {

    @Test
    public void shouldBeBlankButNotEmpty() {
        var blankNonEmpty = "    \n\t";
        assertThat(blankNonEmpty.isBlank()).isTrue();
        assertThat(blankNonEmpty.isEmpty()).isFalse();
    }

   @Test
    public void shouldBeBlankAndEmpty() {
        var blankNonEmpty = "";
        assertThat(blankNonEmpty.isBlank()).isTrue();
        assertThat(blankNonEmpty.isEmpty()).isTrue();
    }

    @Test
    public void shouldBeNeitherBlankNotEmpty() {
        var notBlanNorEmpty = "aaa";
        assertThat(notBlanNorEmpty.isBlank()).isFalse();
        assertThat(notBlanNorEmpty.isEmpty()).isFalse();
    }
}
