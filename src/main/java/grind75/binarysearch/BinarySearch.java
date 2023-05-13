package grind75.binarysearch;

/**
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author Igor Gindin
 * @since 25/01/2023
 */
public class BinarySearch {

    public static void main(String[] args) {
        int [] arr1 = {-1,0,3,5,9,12};
        int [] arr2 = {-1,0,3,5,9,12};

        final BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.search(arr1, 9));
        System.out.println(binarySearch.search(arr2, 2));
    }

    public int search(int[] nums, int target) {

        return findIndex(nums, target, 0, nums.length - 1);
    }

    private int findIndex(int[] nums, int target, int start, int end) {
        int middle = start + ((end - start) / 2);

        if (end < start) {
            return -1;
        }

        if (target == nums[middle]) {
            return middle;
        }

        if (target < nums[middle]) {
            return findIndex(nums, target, start, middle - 1);
        } else {
            return findIndex(nums, target, middle + 1, end);
        }
    }
}

