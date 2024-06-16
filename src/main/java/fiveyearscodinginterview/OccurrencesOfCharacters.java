package fiveyearscodinginterview;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Count Occurrences of Each Character (Max Occurred Character First)
 */
public class OccurrencesOfCharacters {

    private static void occurrencesOfCharacters(String str) {
        Map<Character, Long> map = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.print(entry.getKey() + "" + entry.getValue() + " "));

        System.out.println();
    }

    public static void main(String[] args) {
        String str = "coodinng";
        occurrencesOfCharacters(str);
    }
}
