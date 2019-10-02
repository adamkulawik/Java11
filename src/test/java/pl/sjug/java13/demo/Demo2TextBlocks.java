package pl.sjug.java13.demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Demo2TextBlocks {

    // TODO: 04/10/2019 raw string literals
    @Test
    public void multiLineJava13() {
        // given
        String text = """
          text
          text
          text""";

        // then
        assertThat(text).isEqualTo("text\ntext\ntext");
    }

    @Test
    public void trailwhitespacesLineJava13() {
        // given
        String text = """
          text
          text
          text  """;

        // then
        assertThat(text).isEqualTo("text\ntext\ntext");
    }

    @Test
    public void indentedMultiLineJava13() {
        // given
        String text = """
          text
          text
          text
        """;

        // then
        assertThat(text).isEqualTo("  text\n  text\n  text\n");
    }

    @Test
    public void formattedMultiLineJava13() {
        // given
        String text = """
          text
          %s
          text
          """.formatted("text");

        // then
        assertThat(text).isEqualTo("""
              text
              text
              text
              """);
    }

    @Test
    public void concanateMultiLineJava13() {
        // given
        String text = """
          text
          """ + """
          text
          text
          """;

        // then
        assertThat(text).isEqualTo("""
              text
              text
              text
              """);
    }

}
