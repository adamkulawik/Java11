package pl.sjug.java12.demo;

import lombok.Value;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Demo2String {

    @Test
    public void indentMultiLineJava12() {
        String indentedText = "text\ntext".indent(5);
        assertThat(indentedText).isEqualTo("     text\n     text\n");
    }

    @Test
    public void transform() {
        String result = "text".transform(s -> s + " hello");
        assertThat(result).isEqualTo("text hello");
    }

    @Test
    public void transformLines() {
        String text = "text\ntext";
        String result = text
                .lines()
                .map(s -> s.transform(string -> string + " hello"))
                .collect(Collectors.joining("\n"));
        assertThat(result).isEqualTo("text hello\ntext hello");
    }

    @Test
    public void transformNonString() {
        MeasurementResult measurementResult = "voltage:220".transform(MeasurementResult::transformToResult);
        assertThat(measurementResult.getParam()).isEqualTo("voltage");
        assertThat(measurementResult.getResult()).isEqualTo(220);
    }

    @Value
    private static class MeasurementResult {
        private static MeasurementResult transformToResult(String raw) {
            String[] split = raw.split(":");
            return new MeasurementResult(split[0]   , Double.parseDouble(split[1]));
        }

        String param;
        double result;
    }
}
