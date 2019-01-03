package pl.sjug.java11.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.junit.Before;
import org.junit.Test;

import static java.nio.file.Files.createFile;
import static java.nio.file.Files.delete;
import static java.nio.file.Files.deleteIfExists;
import static java.nio.file.Files.isSameFile;
import static java.nio.file.Files.readString;
import static java.nio.file.Files.writeString;
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
    public void shouldWriteAndReadString() throws IOException {
        // given
        createFile(path);

        // when
        writeString(path, "testText", StandardOpenOption.WRITE);

        // then
        assertThat(readString(path)).isEqualTo(TEST_TEXT);

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
