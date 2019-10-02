package pl.sjug.java11.demo;

import lombok.NonNull;
import org.junit.Test;

import java.util.stream.Stream;

public class Demo0LocalVariableSyntaxLambda {

    @Test
    public void inferredLambda() {
        streamOfNames().reduce((s1, s2) -> s1 + s2);
        streamOfNames().reduce((@NonNull String s1, String s2) -> s1 + s2);
        streamOfNames().reduce((@NonNull  var s1, var s2) -> s1 + s2);
//        streamOfNames().reduce((@NonNull s1, s2) -> s1 + s2);     // WON'T COMPILE
//        streamOfNames().reduce((String s1, s2) -> s1 + s2);       // WON'T COMPILE
//        streamOfNames().reduce((var s1, s2) -> s1 + s2);          // WON'T COMPILE
//        streamOfNames().reduce((var s1, String s2) -> s1 + s2);   // WON'T COMPILE
    }

    private Stream<String> streamOfNames() {
        return Stream.of("Tom", "Jerry");
    }
}
