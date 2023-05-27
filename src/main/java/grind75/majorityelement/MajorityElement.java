package grind75.majorityelement;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement.majorityElement(new int[]{2,2,1,1,2,2,1}));
    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }
            count += res == nums[i] ? 1 : -1;
        }

        return res;

        /*
        let count = 0;
        let candidate = null;
        for (num of nums) {
            if (count === 0) {
                candidate = num;
            }
            count += num === candidate ? 1 : -1;
        }

        count = 0;

        for (num of nums) {
            if (num === candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate: ' ';

         */
    }
}
