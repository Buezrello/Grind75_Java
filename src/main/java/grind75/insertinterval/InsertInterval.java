package grind75.insertinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith interval
 * and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end]
 * that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order
 * by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsBefore = new ArrayList<>();
        List<int[]> intervalsAfter = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] interval : intervals) {
            int currentStart = interval[0];
            int currentEnd = interval[1];
            if (currentEnd < start) {
                intervalsBefore.add(interval);
            } else if (currentStart > end) {
                intervalsAfter.add(interval);
            } else {
                start = Math.min(start, currentStart);
                end = Math.max(end, currentEnd);
            }
        }

        List<int[]> result = new ArrayList<>(intervalsBefore);
        result.add(new int[]{start, end});
        result.addAll(intervalsAfter);

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(Arrays.deepToString(insertInterval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(
                insertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})
        ));
    }
}
