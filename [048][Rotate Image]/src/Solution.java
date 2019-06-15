/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:31
 **/
public class Solution {
    public void rotate(int[][] matrix) {
        int temp;

        // 先做y=x对称转换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再对行进行垂直转换
        int half = matrix.length / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < half; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
