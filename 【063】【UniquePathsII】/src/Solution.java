/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 21:38
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Follow up for "Unique Paths":
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     *
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * [
     *      [0,0,0],
     *      [0,1,0],
     *      [0,0,0]
     * ]
     *
     * The total number of unique paths is 2.
     * Note: m and n will be at most 100.
     *
     * 题目大意：
     * 唯一路径问题后续，如果路径中有障碍，求总的路径的种数
     * 注意：
     * 网格的行数和列数都不超过100
     *
     * 解题思路：
     * 采用分治求解方法
     *
     * </pre>
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 输入校验
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
                || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] result = new int[rows][cols];

        // 第一个位置有多少种方法，无障碍就是1种，有障碍就是0种
        result[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        // 第一行有多少种走法，有障碍就是0
        for (int i = 1; i < cols; i++) {
            result[0][i] = obstacleGrid[0][i] == 0 ? result[0][i - 1] : 0;
        }

        // 第一列有多少种走法，有障碍就是0
        for (int i = 1; i < rows; i++) {
            result[i][0] = obstacleGrid[i][0] == 0 ? result[i - 1][0] : 0;
        }

        // 其它位置的解法，有障碍就是0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = obstacleGrid[i][j] == 0 ? result[i - 1][j] + result[i][j - 1] : 0;
            }
        }

        return result[rows - 1][cols - 1];
    }


    // 使用递归方法会超时
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // 输入校验
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[] result = {0};
        solve(obstacleGrid, 0, 0, result);
        return result[0];
    }

    public void solve(int[][] grid, int row, int col, int[] sum) {
        // 到达终点
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            sum[0]++;
        }
        // 没有到终点，点在棋盘内，并且当前位置不是
        else if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0) {
            // 往右走
            solve(grid, row, col + 1, sum);
            // 往下走
            solve(grid, row + 1, col, sum);
        }
    }
}
