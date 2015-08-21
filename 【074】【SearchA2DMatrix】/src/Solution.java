/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:36
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * For example,
     * Consider the following matrix:　　Given target = 3, return true.
     *
     * [
     *  [1,   3,  5,  7],
     *  [10, 11, 16, 20],
     *  [23, 30, 34, 50]
     * ]
     *
     * 题目大意
     * 给定一个二维矩阵，实现一个算法在矩阵中实现快速搜索。即给定k，在矩阵中搜索k
     * 矩阵中下面的性质：每一行每一列都是排好序的，每一行的第一个数都比上一行的最后一个数大。
     *
     * 解题思路
     * 解法一：先用二叉查看找算法找到数字所在的列，再用二叉查找算法找数字所在的列。找到就返回true，否则返回false
     * </pre>
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = row - 1;
        int mid = 0;

        // 找结果所在的列
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (target < matrix[mid][column - 1]) {
                high = mid - 1;
            } else if (target > matrix[mid][column - 1]) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        // 决定列所在的最终位置
        int targetRow = mid;
        if (matrix[mid][column - 1] < target) {
            targetRow++;
        }

        // 目标列超出，无结果
        if (targetRow >= row) {
            return false;
        }

        low = 0;
        high = column - 1;
        // 找所在的行，找到返回true，没有返回false
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (target < matrix[targetRow][mid]) {
                high = mid - 1;
            } else if (target > matrix[targetRow][mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
