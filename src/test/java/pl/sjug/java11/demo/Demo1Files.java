package pl.sjug.java11.demo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static java.nio.file.Files.*;
import static java.nio.file.Paths.get;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo1Files {

    private Path path;

    @Before
    public void before() {
        path = get("src/test/resources/file.txt");
    }

    @Test
    public void shouldWriteAndReadStringWithExplicitEncoding() throws IOException {
        // given
        createFile(path);

        // when
        writeString(path, "testText", StandardCharsets.UTF_8);

        // then
        assertThat(readString(path, StandardCharsets.UTF_8)).isEqualTo("testText");

        delete(path);
    }

    @Test
    public void shouldFileBeSame() throws IOException {
        // given
        deleteIfExists(path);
        var anotherPath = get("src/test/resources/file.txt");

        // expect
        assertThat(isSameFile(path, anotherPath)).isTrue();
    }
}
