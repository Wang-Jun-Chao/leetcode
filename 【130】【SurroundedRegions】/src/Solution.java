import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 08:51
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * For example,
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     *
     * After running your function, the board should be:
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     *
     * 题目大意：
     * 一个二维风格，包含'X'与'O'，将所以被X包围的O区域用X替代，返回替代后后结果
     * 解题思路：
     * 采用广度优先遍历的方式，（也可以采用尝试深度优先的方式（会有栈溢出））,标记出所有的被包围的点，剩下的就是不被包围的点
     * </pre>
     *
     * @param board
     */
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // 下面采用广度度优先遍历的方式，找出所有的【不】被包围的点
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void solve(char[][] board) {
        // 参数校验
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        // 广度优先搜索时外围一圈的元素
        List<Coordinate> round = new LinkedList<>();
        // 处理顶部行
        for (int col = 0; col < board[0].length; col++) {
            // 顶部行，并且点是O并且点未被访问过
            if (!visited[0][col] && board[0][col] == 'O') {
                round.clear();
                round.add(new Coordinate(0, col));
                bfs(board, visited, round);
            }
        }

        // 处理底部行
        for (int col = 0; col < board[0].length; col++) {
            // 顶部行，并且点是O并且点未被访问过
            if (!visited[board.length - 1][col] && board[board.length - 1][col] == 'O') {
                round.clear();
                round.add(new Coordinate(board.length - 1, col));
                bfs(board, visited, round);
            }
        }

        // 处理左边列
        for (int row = 1; row < board.length - 1; row++) {
            // 顶部行，并且点是O并且点未被访问过
            if (!visited[row][0] && board[row][0] == 'O') {
                round.clear();
                round.add(new Coordinate(row, 0));
                bfs(board, visited, round);
            }
        }

        // 处理右边列
        for (int row = 1; row < board.length - 1; row++) {
            // 顶部行，并且点是O并且点未被访问过
            if (!visited[row][board[0].length - 1] && board[row][board[0].length - 1] == 'O') {
                round.clear();
                round.add(new Coordinate(row, board[0].length - 1));
                bfs(board, visited, round);
            }
        }

        // 标记网格
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 如果未被访问过，有两种可能，第一是X点，第二是O点，O点一定是被X包围的
                // 此时将未访问过的点设置为X是正确的
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 深度优先，找不被包围的点
     *
     * @param board   二维网格
     * @param visited 访问标记数组
     * @param round   广度优先搜索时外围一圈的元素
     */
    public void bfs(char[][] board, boolean[][] visited, List<Coordinate> round) {
        Coordinate c;
        while (round.size() > 0) {
            c = round.remove(0);
            if (c.x >= 0 && c.x < board.length && c.y >= 0 && c.y < board[0].length && board[c.x][c.y] == 'O' && !visited[c.x][c.y]) {
                visited[c.x][c.y] = true;
                round.add(new Coordinate(c.x - 1, c.y));
                round.add(new Coordinate(c.x, c.y + 1));
                round.add(new Coordinate(c.x + 1, c.y));
                round.add(new Coordinate(c.x, c.y - 1));
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // 下面采用广度度优先遍历的方式，找出所有的被包围的点，并且标记会超时
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void solve2(char[][] board) {
        // 参数校验
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        // 广度优先搜索时外围一圈的元素
        List<Coordinate> round = new LinkedList<>();
        // 广度优先搜索进的所有元素
        List<Coordinate> all = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    // 广度优先搜索第一圈的元素
                    round.add(new Coordinate(i, j));
                    boolean result = bfs(board, visited, round, all);
                    // 一次搜索的所有O都在网格内，并且不在边界上
                    if (result) {
                        // 设置标记
                        for (Coordinate c : all) {
                            board[c.x][c.y] = 'X';
                        }
                    }

                    // 清空元素
                    round.clear();
                    all.clear();
                }
            }
        }

    }

    /**
     * 广度优先遍历
     *
     * @param board   二维网格
     * @param visited 访问标记数组
     * @param round   广度优先搜索时外围一圈的元素
     * @param all     广度优先搜索进的所有元素
     * @return true点是O，点在网格内，并且不在边界上，如果点是X，总返回true
     */
    public boolean bfs(char[][] board, boolean[][] visited, List<Coordinate> round, List<Coordinate> all) {
        boolean result = true;
        int size = round.size();
        Coordinate c;
        while (size > 0) {
            size--;

            // 取队首元素
            c = round.remove(0);
            // 添加到遍历记录元素集合中
            all.add(c);
            // 标记已经被访问过了
            visited[c.x][c.y] = true;
            // 判断c是否是O内点
            result &= isInner(board, c.x, c.y);

            // c的上面一个点是否是O，并且没有访问过，满足就添加到round队列中
            if (isO(board, c.x - 1, c.y) && !visited[c.x - 1][c.y]) {
                round.add(new Coordinate(c.x - 1, c.y));
            }

            // c的右面一个点是否是O，并且没有访问过，满足就添加到round队列中
            if (isO(board, c.x, c.y + 1) && !visited[c.x][c.y + 1]) {
                round.add(new Coordinate(c.x, c.y + 1));
            }

            // c的下面一个点是否是O，并且没有访问过，满足就添加到round队列中
            if (isO(board, c.x + 1, c.y) && !visited[c.x + 1][c.y]) {
                round.add(new Coordinate(c.x + 1, c.y));
            }

            // c的左面一个点是否是O，并且没有访问过，满足就添加到round队列中
            if (isO(board, c.x, c.y - 1) && !visited[c.x][c.y - 1]) {
                round.add(new Coordinate(c.x, c.y - 1));
            }
        }

        if (round.size() > 0) {
            return bfs(board, visited, round, all) && result;
        } else {
            return result;
        }

    }

    /**
     * 判断点在二维风格内部，并且不在边界上
     *
     * @param board 二维网格
     * @param x     横坐标
     * @param y     纵坐标
     * @return true是
     */
    public boolean isInner(char[][] board, int x, int y) {
        return x > 0 && x < board.length - 1 && y > 0 && y < board[0].length - 1;
    }

    /**
     * 判断点是否是O
     *
     * @param board 二维网格
     * @param x     横坐标
     * @param y     纵坐标
     * @return true是
     */
    public boolean isO(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O';
    }

    /**
     * 坐标对象
     */
    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate() {
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
