package by.st.streamApi;

import java.util.Arrays;
import java.util.List;

public class StreamApiMain {
    public static void main(String[] args) {

        getMyStrings().stream()
                .filter(s -> s.startsWith("s"))
                .filter(s -> s.endsWith("4"))
                .forEach(System.out::println);

        getMyIntegers().stream()
                .filter(integer -> integer % 2 == 0)
                .sorted()
                .forEach(System.out::println);
    }

    public static List<String> getMyStrings(){
        return  Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6", "string7");
    }

    private static List<Integer> getMyIntegers(){
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

}
