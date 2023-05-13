package grind75.ransomnote;

import java.util.*;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote
 * can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {
    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();

//        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
//        System.out.println(ransomNote.canConstruct("aac", "aab"));

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> ransom = convertArrayToList(ransomNote.toCharArray());
        List<Character> mag = convertArrayToList(magazine.toCharArray());

        for (Character ch : mag) {
            ransom.remove(ch);
        }

        return ransom.isEmpty();
    }

    private List<Character> convertArrayToList(char[] arr) {
        List<Character> result = new ArrayList<>();
        for (char c : arr) {
            result.add(c);
        }

        return result;
    }
}
