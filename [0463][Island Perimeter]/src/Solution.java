/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 12:58
 **/
public class Solution {

    /**
     * <pre>
     * You are given a map in form of a two-dimensional integer grid where 1 represents
     * land and 0 represents water.
     *
     * Grid cells are connected horizontally/vertically (not diagonally). The grid is
     * completely surrounded by water, and there is exactly one island (i.e., one or more
     * connected land cells).
     *
     * The island doesn't have "lakes" (water inside that isn't connected to the water around
     * the island). One cell is a square with side length 1. The grid is rectangular, width
     * and height don't exceed 100. Determine the perimeter of the island.
     *
     * Example:
     *
     * Input:
     * [[0,1,0,0],
     *  [1,1,1,0],
     *  [0,1,0,0],
     *  [1,1,0,0]]
     *
     * Output: 16
     *
     * Explanation: The perimeter is the 16 yellow stripes in the image below:
     * </pre>
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {

        // 假定输入都是合法的

        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    // 上一格
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter++;
                    }

                    // 下一格
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        perimeter++;
                    }

                    // 左一格
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter++;
                    }

                    // 右一格
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        perimeter++;
                    }
                }
            }
        }

        // 如果在第一列和最后一列，第一行和最后一行有一，要再加上1出现的数次数

        for (int i = 0; i < grid.length; i++) {
            // 第一列有一
            perimeter += grid[i][0];
            // 最后一列有一
            perimeter += grid[i][grid[0].length - 1];
        }

        for (int i = 0; i < grid[0].length; i++) {
            // 第一行有一
            perimeter += grid[0][i];
            // 最后一行有一
            perimeter += grid[grid.length - 1][i];
        }

        return perimeter;
    }
}
