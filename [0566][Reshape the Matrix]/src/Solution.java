/**
 * Author: 王俊超
 * Time: 2020-07-02 08:43
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            result[i] = new int[c];
        }

        int num = row * col;

        for (int i = 0; i < num; i++) {
            result[i / c][i % c] = nums[i / col][i % col];
        }

        return result;
    }
}
