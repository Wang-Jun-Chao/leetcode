/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:28
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * For example,
     * Given n = 3,
     * You should return the following matrix:
     *
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     *
     * 题目大意
     * 给定一个整数n，生成一个n*n的矩阵，用1-n^2的数字进行螺旋填充。
     *
     * 解题思路
     * 采用计算生成法，对每一个位置计算对应的数。
     * </pre>
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int layer;
        int k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                layer = layer(i, j, n); // 当前坐标外有几层
                // n * n - layer * layer外围层使用的最后一个数字（也是最大的）
                // 坐标所在的当前层使用的第一个数字
                k = n * n - (n - 2 * layer) * (n - 2 * layer) + 1;
                result[i][j] = k;

                // (n - 2 * layer - 1)：四个(n - 2 * layer - 1)就是（x，y）坐标所在层的所有元素个数
                if (i == layer) { // 情况一、坐标离上边界最近
                    result[i][j] = k + j - layer;
                } else if (j == n - layer - 1) { // 情况二、坐标离右边界最近
                    result[i][j] = k + (n - 2 * layer - 1) + i - layer;
                } else if (i == n - layer - 1) { // 情况三、坐标离下边界最近
                    result[i][j] = k + 3 * (n - 2 * layer - 1) - (j - layer);
                } else { // 情况三、坐标离左边界最近
                    result[i][j] = k + 4 * (n - 2 * layer - 1) - (i - layer);
                }
            }
        }

        return result;
    }

    /**
     * 在一个n*n的矩阵中，计算（x,y）坐标外有多少层，坐标从0开始计算
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @param n 矩阵大小
     * @return 坐标外的层数
     */
    public int layer(int x, int y, int n) {
        x = x < n - 1 - x ? x : n - 1 - x; // 计算横坐标离上下边界的最近距离
        y = y < n - 1 - y ? y : n - 1 - y; // 计算纵坐标离左右边界的最近距离

        return x < y ? x : y; // 较小的值为坐标的外围层数
    }
}
