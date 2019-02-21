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

    @Test
    public void shouldWriteAndReadStringWithExplicitEncoding() throws IOException {
        // given
        Files.createFile(path);

        // when
        Files.writeString(path, "testText", StandardCharsets.UTF_8);

        // then
        assertThat(Files.readString(path, StandardCharsets.UTF_8)).isEqualTo("testText");

        Files.delete(path);
    }

    @Test
    public void shouldFileBeSame() throws IOException {
        // given
        Files.deleteIfExists(path);
        var anotherPath = get("src/test/resources/file.txt");

        // expect
        assertThat(Files.isSameFile(path, anotherPath)).isTrue();
    }
}
