/**
 * Author: ������
 * Date: 2015-06-20
 * Time: 11:00
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally
     * or vertically. You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *      11110
     *      11010
     *      11000
     *      00000
     * Answer: 1
     *
     * Example 2:
     *      11000
     *      11000
     *      00100
     *      00011
     * Answer: 3
     *
     * ��Ŀ���⣺
     * ������һ����ά����ĵ�ͼ��'1'��½�أ���0��ˮ�����������������������������滷ˮ��
     * �������ڵ�½��ˮƽ��ֱ���Ӷ��γɵġ�����Լ��������������ĸ��߶���ˮ��Χ��
     *
     * ����˼·��
     * һ��������һ����Ӧ�ķ��ʱ�Ǿ��󣬶�����ÿ��Ԫ��ʱ�й�����ȱ���������������ȱ�������ͳ�Ƶ�����Ŀ
     *
     * </pre>
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        // ����У��
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // Ԫ��Ĭ��ֵ��false
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // �����λ��û�б����ʹ������Ҵ�λ���ǵ�������¹�����ȱ���
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return result;
    }

    /**
     * �����������
     *
     * @param grid    ����
     * @param visited ���ʱ�Ǿ���
     * @param row     ������
     * @param col     ������
     */
    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {

        if (row >= 0 && row < grid.length // �кϷ�
                && col >= 0 && col < grid[0].length // �кϷ�
                && !visited[row][col] // û�з��ʹ�
                && grid[row][col] == '1') { // �ǵ���½��

            // ��Ǵ�λ���Ѿ����ʹ���
            visited[row][col] = true;

            // ��
            bfs(grid, visited, row - 1, col);
            // ��
            bfs(grid, visited, row, col + 1);
            // ��
            bfs(grid, visited, row + 1, col);
            // ��
            bfs(grid, visited, row, col - 1);
        }
    }
}
