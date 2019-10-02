package pl.sjug.java11.demo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Paths.get;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo4Files {

    private Path path;

    @Before
    public void before() {
        path = get("src/test/resources/file.txt");
    }

    // TODO: 10/10/2019 open options
    @Test
    public void writeAndReadStringWithExplicitEncoding() throws IOException {
        // given
        Files.createFile(path);

        // when
        Files.writeString(path, "testText", StandardCharsets.UTF_8);

        // then
        assertThat(Files.readString(path, StandardCharsets.UTF_8)).isEqualTo("testText");

        Files.delete(path);
    }
}
