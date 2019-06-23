/**
 * Author: 王俊超
 * Date: 2015-07-25
 * Time: 09:27
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // 第一行被设置的标志
        boolean rowFlag = false;
        // 第一列被设置的标志
        boolean colFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // 标记第一行要被设置
                    if (i == 0) {
                        rowFlag = true;
                    }

                    // 标记第一列要被设置
                    if (j == 0){
                        colFlag = true;
                    }

                    // 在行列在标记要设置为0的行和列
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 对第二行第二列开始的元素设置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 设置第一行为0
        if (rowFlag) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // 设置第一列为0
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
