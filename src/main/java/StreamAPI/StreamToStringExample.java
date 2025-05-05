package StreamAPI;

import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StreamToStringExample {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Hello", "world");
        String result = getStringFromStream(stream);
        System.out.println(result);
    }

    public static String getStringFromStream(Stream<String> stringStream) {
        return stringStream.collect(Collectors.joining(" "));
    }
}