import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:09
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given an index k, return the kth row of the Pascal’s triangle.
     * For example, given k = 3,
     * Return [1,3,3,1].
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     *
     * 题目大意
     * 给定一个正整数k，求帕斯卡的第k行。
     *
     * 解题思路
     * 对任意的n>0有
     * f(1, n)=1，(n>0)
     * f(n, n)=1，(n>2)
     * f(i,j) = f(i-1, j-1)+f(i, j-1)，i>2,j>2，
     * 求第k行。
     * </pre>
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {

        rowIndex++; // 第rowIndex的实质数据数目

        if (rowIndex < 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>(rowIndex);

        if (rowIndex >= 1) {
            result.add(1);
        }

        if (rowIndex >= 2) {
            result.add(1);
        }

        int line = 0; // 记录当前使用哪一行
        int prev; // 上一行是哪一行
        if (rowIndex >= 3) {

            int[][] data = new int[2][rowIndex];
            // 【1】
            data[0][0] = 1;
            data[1][0] = 1;
            data[1][1] = 1;

            for (int i = 2; i < rowIndex; i++) {
                line = i % 2; // 新计算的数据保存在第0或者第1行
                prev = (i - 1 + 2) % 2;
//                data[line][0] = 1; // 设置第一个数字，可以不用，【1】处已经进行了，data[x][0]总为1
                for (int j = 1; j < i; j++) {
                    data[line][j] = data[prev][j - 1] + data[prev][j];
                }

                data[line][i] = 1; // 设置最后一个数
            }

            //
            result.clear();
            for (int i = 0; i < rowIndex; i++) {
                result.add(data[line][i]);
            }

        }

        return result;
    }
}
