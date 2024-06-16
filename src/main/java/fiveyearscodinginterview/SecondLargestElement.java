package fiveyearscodinginterview;

import java.util.Arrays;
import java.util.Collections;

/**
 * find second-largest element in array
 */
public class SecondLargestElement {

    private static int secondLargestWithoutSorting(int[] arr) {
        if (arr == null || arr.length <2) {
            throw new IllegalArgumentException("Input array must contain two elements at least");
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j < max) {
                secondMax = j;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Second-Largest element not found, all elements are equal");
        }

        return secondMax;
    }

    private static int secondLargestWithSorting(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
//                .limit(2)
                .skip(1)
                .findFirst().orElseThrow();

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 6, 3, 2 };
        System.out.println("Second-Largest element without sorting is " + secondLargestWithoutSorting(arr));
        System.out.println("Second-Largest element with sorting is " + secondLargestWithSorting(arr));
        int[] arr2 = { 5, 5, 5 };
        System.out.println("Second-Largest element without sorting is " + secondLargestWithoutSorting(arr2));
    }
}
