package fiveyearscodinginterview;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Count Frequency of Each Character in Alphabetical Order
 */
public class FrequencyOfCharacters {

    private static void frequencyOfCharacters(String str) {
        Map<Character, Long> map = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.print(e.getKey() + "" + e.getValue() + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "coodinng";
        frequencyOfCharacters(str);
    }
}
