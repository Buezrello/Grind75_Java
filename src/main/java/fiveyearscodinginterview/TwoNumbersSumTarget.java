package fiveyearscodinginterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * find indexes of two numbers in array that their sum equals to target
 */
public class TwoNumbersSumTarget {

    private static int[] indexesOfTwoElementsEqualsToTarget(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            }

            map.put(arr[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 11, 7, 15 };
        int target = 9;

        System.out.println(Arrays.toString(indexesOfTwoElementsEqualsToTarget(arr, target)));
    }
}
