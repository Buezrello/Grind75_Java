package grind75.validpalindrome;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = " ";
        String str4 = ".,";
        System.out.println(validPalindrome.isPalindrome(str1));
        System.out.println(validPalindrome.isPalindrome(str2));
        System.out.println(validPalindrome.isPalindrome(str3));
        System.out.println(validPalindrome.isPalindrome(str4));
    }

    public boolean isPalindrome(String s) {
        List<Character> characterList = s.chars()
                .mapToObj(i->(char)i)
                .filter(ch -> (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                .collect(Collectors.toList());

        for (int i=0, j=characterList.size()-1; i<j; i++, j--) {
            if (convertCharToLowercase(characterList.get(i)) != convertCharToLowercase(characterList.get(j))) {
                return false;
            }
        }

        return true;
    }

//    private boolean notAlphanumericChar(char ch) {
//        return (ch < '0' || ch > '9') && (ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z');
//    }

    private char convertCharToLowercase(char ch) {
        return (ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch;
    }
}
