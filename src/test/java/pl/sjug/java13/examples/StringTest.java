package pl.sjug.java13.examples;

import org.junit.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    // Java 12 novelties
    @Test
    public void indentSingleLine() {
        // given
        String text = "text";

        // when
        String indentedText = text.indent(5);

        // then
        assertThat(indentedText).isEqualTo("     text\n"); // EOL added
    }

    @Test
    public void indentMultiLineJava12() {
        // given
        String text = "text\ntext";

        // when
        String indentedText = text.indent(5);

        // then
        assertThat(indentedText).isEqualTo("     text\n     text\n"); // EOL added
    }

    @Test
    public void transform () {
        // given
        String text = "text";

        // when
        String result = text.transform(s -> s + " hello");

        //then
        assertThat(result).isEqualTo("text hello");
    }

    @Test
    public void transformLines () {
        // given
        String text = "text\ntext";

        // when
        String result = text.lines().map(s -> s.transform(string -> string + " hello")).collect(Collectors.joining("\n"));

        //then
        assertThat(result).isEqualTo("text hello\ntext hello");
    }

    // Java 13 novelties
    @Test
    public void indentMultiLineJava13 () {
        // given
        String text = """
          .
          text
          text
          text
          """;

        // when
        String indentedText = text.indent(5);

        // then
        assertThat(indentedText).isEqualTo("     .\n     text\n     text\n     text\n"); // EOL added
        assertThat(indentedText).isEqualTo("""
              .
              text
              text
              text
         """); // EOL added
    }
}
