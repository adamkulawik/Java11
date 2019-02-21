package pl.sjug.java11.examples.files;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static java.nio.file.Files.*;
import static java.nio.file.Paths.get;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesTest {

    private static final String TEST_TEXT = "testText";
    private Path path;

    @Before
    public void before() {
        path = get("src/test/resources/file.txt");
    }

    @Test
    public void shouldWriteAndReadStringWithDefaultEncoding() throws IOException {
        // given
        createFile(path);

        // when
        writeString(path, TEST_TEXT);

        // then
        assertThat(readString(path)).isEqualTo(TEST_TEXT);

        delete(path);
    }

    @Test
    public void shouldWriteAndReadStringWithExplicitEncoding() throws IOException {
        // given
        createFile(path);

        // when
        writeString(path, TEST_TEXT, StandardCharsets.UTF_8);

        // then
        assertThat(readString(path, StandardCharsets.UTF_8)).isEqualTo(TEST_TEXT);

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
