package grind75.longestpalindrome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
 * <p>
 * Example:
 * <p>
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * @author Igor Gindin
 * @since 23/01/2023
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "a";
        String s3 = "abcdadcb";

        final LongestPalindrome longestPalindrome = new LongestPalindrome();

        System.out.println(longestPalindrome.longestPalindrome(s1));
        System.out.println(longestPalindrome.longestPalindrome(s2));
        System.out.println(longestPalindrome.longestPalindrome(s3));
    }

    public int longestPalindrome(String s) {
        boolean odd = false;
        Map<String, Long> charCountMap =
                Arrays.stream(s.split("")).collect(Collectors.groupingBy(str -> str, HashMap::new, Collectors.counting()));
        long palindromeLength = 0;
        for (long count : charCountMap.values()) {
            long mod = count % 2;
            if (mod == 1) {
                odd = true;
            }
            palindromeLength += count - mod;
        }
        int mod = s.length() % 2;
        if (!odd &&  mod == 1) {
            odd = true;
        }
        if (odd) {
            palindromeLength += 1;
        }

        return (int) palindromeLength;
    }

}
