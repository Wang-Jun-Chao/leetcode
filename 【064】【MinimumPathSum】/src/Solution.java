/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 15:59
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * Given a m x n grid filled with non-negative numbers, find a path from top
     * left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * 题目大意：
     * 给定一个m x n的方格，每个元素的值都是非负的，找出从左上角顶点，到右下角顶点和的值最小的路径，
     * 返回找到的最小和
     *
     * 注意：
     *   - 每次只能向下获取向上移动一个方格
     *
     * 钥匙思路：
     * 分治法，
     * 第一个：  S[0][0] = grid[0][0]
     * 第一行：  S[0][j] = S[0][j - 1] + grid[0][j]
     * 第一列：  S[i][0] = S[i - 1][0] + grid[i][0]
     * 其它情况：S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j]
     * </pre>
     *
     * @param grid
     * @return
     */

    public int minPathSum(int[][] grid) {
        // 参数检验
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }


        int[][] result = new int[grid.length][grid[0].length];
        // 第一个
        result[0][0] = grid[0][0];

        // 第一行
        for (int i = 1; i < result[0].length; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }

        // 第一列
        for (int i = 1; i < result.length; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }

        // 其它情况
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }

        return result[result.length - 1][result[0].length - 1];
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // 动态归划和分枝限界，下面的方法会超时
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int minPathSum2(int[][] grid) {
        // 参数检验
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        // 用于记录最小的路径各
        int[] minSum = {Integer.MAX_VALUE};
        int[] curSum = {0};
        // 解题
        solve(grid, 0, 0, curSum, minSum);

        // 返回结果
        return minSum[0];
    }

    public void solve(int[][] grid, int row, int col, int[] curSum, int[] minSum) {
        // 如果已经到达终点
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            curSum[0] += grid[row][col];

            // 更新最小的和
            if (curSum[0] < minSum[0]) {
                minSum[0] = curSum[0];
            }

            curSum[0] -= grid[row][col];
        }
        // 还未到达终点，并且在网格内
        else if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            curSum[0] += grid[row][col];
            // 当前的和只有不小于记录到的最小路径值才能进行下一步操作
            if (curSum[0] <= minSum[0]) {
                // 向右走
                solve(grid, row, col + 1, curSum, minSum);
                // 向下走
                solve(grid, row + 1, col, curSum, minSum);
            }
            curSum[0] -= grid[row][col];
        }
    }
}
