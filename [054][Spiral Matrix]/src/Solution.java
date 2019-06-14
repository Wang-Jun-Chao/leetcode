import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 17:11
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a matrix of m x n elements (m rows, n columns), return all elements
     * of the matrix in spiral order.
     * For example,
     * Given the following matrix:
     *
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     *
     * You should return [1,2,3,6,9,8,7,4,5].
     * 题目大意
     * 给定一个m*n的矩阵，输入所有元素的螺旋顺序。
     *
     * 解题思路
     * 使用计算输出的方法，先处理上面一行，再处理右边一列，再处理下面一行，再处理左边一列，
     * 一直这样操作，直到所有的元素都处理完。
     * </pre>
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(50);

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 只有一行的情况
        if (matrix.length == 1) {
            for (int i : matrix[0]) {
                result.add(i);
            }

            return result;
        }

        // 只有一列的情况
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }

            return result;
        }

        // 计算有多少圈
        int row = matrix.length;
        int col = matrix[0].length;
        int cycle = row < col ? row : col;
        cycle = (cycle + 1) / 2;

        int round = 0; // 记录当前是第几圈
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        int total = col * row;
        int count = 0;
        while (round < cycle) {

            // 上面一行
            for (int i = left; i <= right && count < total; i++) {
                count++;
                result.add(matrix[round][i]);
            }
            top++; //

            // 右边一列
            for (int i = top; i <= down && count < total; i++) {
                count++;
                result.add(matrix[i][col - round - 1]);
            }
            right--;

            // 底下一行
            for (int i = right; i >= left && count < total; i--) {
                count++;
                result.add(matrix[row - round - 1][i]);

            }
            down--;

            // 左边一列
            for (int i = down; i >= top && count < total; i--) {
                count++;
                result.add(matrix[i][round]);
            }
            left++;

            round++;
        }

        return result;
    }
}
