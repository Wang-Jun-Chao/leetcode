import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-23
 * Time: 08:51
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a triangle, find the minimum path sum from top to bottom.
     * Each step you may move to adjacent numbers on the row below.
     *
     * For example, given the following triangle
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     *
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * Note:
     * Bonus point if you are able to do this using only O(n) extra space,
     * where n is the total number of rows in the triangle.
     *
     * 题目大意：
     * 给定一个三角形，找出从顶到底的最小路径和，每一步可以从上一行移动到下一行相邻的数字
     *
     * 解题思路：
     * 递推方程：
     * f(0,0)=a[0][0]
     * f(i,0)=a[i][0]+f(i-1,0) (i>0)
     * f(i,i)=a[i][i]+f(i-1,i-1)(i>0)
     * f(i,j)=a[i][j]+MIN(f(i-1,j),f(i-1,j-1))(0<j<i)
     * </pre>
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        // 创建数组的第二维度
        int[][] minSum = new int[triangle.size()][];

        // 创建数组的第一维度
        for (int i = 0; i < minSum.length; i++) {
            minSum[i] = new int[i + 1];
        }
        // 设置第一行
        minSum[0][0] = triangle.get(0).get(0);
        // 设置其它行
        for (int i = 1; i < minSum.length; i++) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < minSum[i].length; j++) {
                if (j == 0) {
                    minSum[i][0] = line.get(0) + minSum[i - 1][0];
                } else if (i == j) {
                    minSum[i][j] = line.get(j) + minSum[i - 1][j - 1];
                } else if (j < i) {
                    minSum[i][j] = line.get(j) + Math.min(minSum[i - 1][j], minSum[i - 1][j - 1]);
                }
            }
        }
        //找最后一行的最小值就是所求的解
        int min = minSum[minSum.length - 1][0];
        int length = minSum[minSum.length - 1].length;
        for (int i = 1; i < length; i++) {
            if (min > minSum[length - 1][i]) {
                min = minSum[length - 1][i];
            }
        }

        return min;
    }
}
