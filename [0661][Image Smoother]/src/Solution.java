/**
 * Author: 王俊超
 * Time: 2020-07-06 08:11
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {

    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][];
        for (int i = 0; i < M.length; i++) {
            result[i] = new int[M[i].length];
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int count = 0;
                int sum = 0;
                for (int u = Math.max(0, i - 1); u <= i + 1 && u < M.length; u++) {
                    for (int v = Math.max(0, j - 1); v <= j + 1 && v < M[0].length; v++) {
                        count++;
                        sum += M[u][v];
                    }
                }
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
