import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 13:25
 **/
public class Solution {
    /**
     * <pre>
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
     *
     * The distance between two adjacent cells is 1.
     *
     *
     *
     * Example 1:
     *
     * Input:
     * [[0,0,0],
     *  [0,1,0],
     *  [0,0,0]]
     *
     * Output:
     * [[0,0,0],
     *  [0,1,0],
     *  [0,0,0]]
     * Example 2:
     *
     * Input:
     * [[0,0,0],
     *  [0,1,0],
     *  [1,1,1]]
     *
     * Output:
     * [[0,0,0],
     *  [0,1,0],
     *  [1,2,1]]
     *
     *  Note:
     *
     * The number of elements of the given matrix will not exceed 10,000.
     * There are at least one 0 in the given matrix.
     * The cells are adjacent in only four directions: up, down, left and right.
     * 类似广度优化遍历
     * </pre>
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {

        boolean[][] visit = new boolean[matrix.length][];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < visit.length; i++) {
            visit[i] = new boolean[matrix[i].length];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    visit[i][j] = true;
                    deque.addLast(i);
                    deque.addLast(j);
                    deque.addLast(0);
                }
            }
        }

        while (!deque.isEmpty()) {
            int i = deque.removeFirst();
            int j = deque.removeFirst();
            int v = deque.removeFirst();

            // 上一个
            if (i - 1 >= 0 && !visit[i - 1][j]) {
                visit[i - 1][j] = true;
                matrix[i - 1][j] = v + 1;
                deque.addLast(i - 1);
                deque.addLast(j);
                deque.addLast(v + 1);
            }

            // 下一个
            if (i + 1 < matrix.length && !visit[i + 1][j]) {
                visit[i + 1][j] = true;
                matrix[i + 1][j] = v + 1;
                deque.addLast(i + 1);
                deque.addLast(j);
                deque.addLast(v + 1);
            }

            // 左一个
            if (j - 1 >= 0 && !visit[i][j - 1]) {
                visit[i][j - 1] = true;
                matrix[i][j - 1] = v + 1;
                deque.addLast(i);
                deque.addLast(j - 1);
                deque.addLast(v + 1);
            }

            // 右一个
            if (j + 1 < matrix[0].length && !visit[i][j + 1]) {
                visit[i][j + 1] = true;
                matrix[i][j + 1] = v + 1;
                deque.addLast(i);
                deque.addLast(j + 1);
                deque.addLast(v + 1);
            }
        }

        return matrix;
    }
}
