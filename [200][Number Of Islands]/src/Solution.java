/**
 * Author: 王俊超
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
     * 题目大意：
     * 给定的一个二维网格的地图（'1'（陆地）和0（水）），计数岛的数量。岛屿是四面环水，
     * 是由相邻的陆地水平或垂直连接而形成的。你可以假设该网格的所有四个边都被水包围。
     *
     * 解题思路：
     * 一个网格，有一个相应的访问标记矩阵，对网格每个元素时行广度优先遍历（或者深度优先遍历），统计岛的数目
     *
     * </pre>
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        // 参数校验
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // 元素默认值是false
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果此位置没有被访问过，并且此位置是岛，就里德广度优先遍历
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return result;
    }

    /**
     * 广度优先搜索
     * @param grid 网格
     * @param visited 访问标记矩阵
     * @param row 横坐标
     * @param col 纵坐标
     */
    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {

        if (row >= 0 && row < grid.length // 行合法
                && col >= 0 && col < grid[0].length // 列合法
                && !visited[row][col] // 没有访问过
                && grid[row][col] == '1') { // 是岛上陆地

            // 标记此位置已经访问过了
            visited[row][col] = true;

            // 上
            bfs(grid, visited, row - 1, col);
            // 右
            bfs(grid, visited, row, col + 1);
            // 下
            bfs(grid, visited, row + 1, col);
            // 左
            bfs(grid, visited, row, col - 1);
        }
    }
}
