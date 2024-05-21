package grind75.zeroonematrix;

import java.util.Arrays;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * Example 2:
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
public class ZeroOneMatrix {

    public static void main(String[] args) {
        int[][] first = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        int[][] second = new int[][]{{0,0,0}, {0,1,0}, {1,1,1}};

        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();

        first = zeroOneMatrix.updateMatrix(first);
        second = zeroOneMatrix.updateMatrix(second);

        System.out.println(Arrays.deepToString(first));
        System.out.println(Arrays.deepToString(second));

    }

    public int[][] updateMatrix(int[][] mat) {
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = 1 + minAsc(mat, i, j);
                }
            }
        }

        for (int i=mat.length-1; i>=0; i--) {
            for (int j=mat[0].length-1; j>=0; j--) {
                mat[i][j] = Math.min(mat[i][j], 1+minDesc(mat, i, j));
            }
        }

        return mat;
    }

    private int minAsc(int[][] mat, int i, int j) {
        int result = Math.min(
                i > 0 ? mat[i-1][j] : Integer.MAX_VALUE,
                j > 0 ? mat[i][j-1] : Integer.MAX_VALUE
        );

        if (result == Integer.MAX_VALUE) result--;

        return result;
    }

    private int minDesc(int[][] mat, int i, int j) {
        int result = Math.min(
                i + 1 < mat.length ? mat[i+1][j] : Integer.MAX_VALUE,
                j + 1 < mat[0].length ? mat[i][j+1] : Integer.MAX_VALUE
        );

        if (result == Integer.MAX_VALUE) result--;

        return result;
    }
}
