import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 14:54
 **/
public class Main {
    @Test
    public void test1() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        Solution solution = new Solution();
        matrix = solution.updateMatrix(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        Solution solution = new Solution();
        matrix = solution.updateMatrix(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}};
        Solution solution = new Solution();
        matrix = solution.updateMatrix(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

    }

    @Test
    public void test4() {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1}};
        Solution solution = new Solution();
        matrix = solution.updateMatrix(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    @Test
    public void test5() {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1}};
        Solution solution = new Solution();
        matrix = solution.updateMatrix(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
