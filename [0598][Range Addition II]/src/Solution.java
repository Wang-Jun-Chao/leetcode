/**
 * Author: 王俊超
 * Time: 2020-07-04 15:50
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 数组的第一元素一定是最大的，要找最大的元素个数，只要找ops中min(ops[0])*min(ops[1])
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {


        int row = m;
        int col = n;
        for (int[] op : ops) {
            row = Math.min(op[0], row);
            col = Math.min(op[1], col);
        }

        return row * col;
    }
}
