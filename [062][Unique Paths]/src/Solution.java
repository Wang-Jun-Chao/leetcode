/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:30
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * A robot is located at the top-left corner of a m x n grid
     * (marked ‘Start’ in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid
     * (marked ‘Finish’ in the diagram below).
     * How many possible unique paths are there?
     *
     * Above is a 3 x 7 grid. How many possible unique paths are there?
     * Note: m and n will be at most 100.
     *
     * 题目大意
     * 一个机器人在一个m*n的方格的左上角。
     * 机器人只能向右或都向下走一个方格，机器人要到达右下角的方格。
     * 请问一共有多少种唯一的路径。
     * 注意：ｍ和ｎ最大不超100。
     *
     * 解题思路
     * 典型的动态规划问题，对问题使用动态规划的方法进行求解。
     * 用一个ｍ*n的组数A保存结果。
     * 对于A数组中的元素有。
     * 1、当x=0或者y=0时有A[x][y] = 1；
     * 2、当x>=1并且y>=1时有A[\x][\y] = A[x-1][y]+A[\x][y-1]。
     * 3、所求的结点就是A[m-1][n-1]。
     * </pre>
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];

        // 第一列的解
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }

        // 第一行的解
        for (int i = 1; i < n; i++) {
            result[0][i] = 1;
        }

        // 其它位置的解
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }

        // 所求的解
        return result[m - 1][n - 1];
    }
}
