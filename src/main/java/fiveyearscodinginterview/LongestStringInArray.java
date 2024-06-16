package fiveyearscodinginterview;

/**
 * find the longest string in array most efficient way
 */
public class LongestStringInArray {

    private static String longestString(String[] input) {

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty");
        }

        int indexOfLongestString = 0;
        int longestString = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i].length() > longestString) {
                longestString = input[i].length();
                indexOfLongestString = i;
            }
        }
        return input[indexOfLongestString];
    }

    public static void main(String[] args) {
        System.out.println(longestString(new String[] { "apple", "banana", "orange", "kiwi", "strawberry" }));
    }
}
