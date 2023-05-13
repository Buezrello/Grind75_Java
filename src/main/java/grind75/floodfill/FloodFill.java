package grind75.floodfill;

import java.util.Arrays;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image
 * starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally
 * to the starting pixel
 * of the same color as the starting pixel, plus any pixels connected 4-directionally
 * to those pixels (also with the same color), and so on.
 * Replace the color of all the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 *
 * @author Igor Gindin
 * @since 30/01/2023
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int[][] image1 = {{0,0,0}, {0,0,0}};

        final FloodFill floodFill = new FloodFill();

        final int[][] ints = floodFill.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(ints));

        final int[][] ints1 = floodFill.floodFill(image1, 0, 0, 0);
        System.out.println(Arrays.deepToString(ints1));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return floodFill(image, sr, sc, image[sr][sc], color);
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int prevColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length) {
            return image;
        }

        if (image[sr][sc] == color || image[sr][sc] != prevColor) {
            return image;
        }


        image[sr][sc] = color;

        image = floodFill(image, sr - 1, sc, prevColor, color);
        image = floodFill(image, sr + 1, sc, prevColor, color);
        image = floodFill(image, sr, sc - 1, prevColor, color);
        image = floodFill(image, sr, sc + 1, prevColor, color);

        return image;
    }
}
