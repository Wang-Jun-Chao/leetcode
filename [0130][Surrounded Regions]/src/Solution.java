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
     * 采用深度度优先遍历的方式，找出不被X包围的O，标记为$
     * </pre>
     *
     * @param board
     */
    void solve(char[][] board) {

        // 参数校验
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        // 处理第一行和最后行
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        // 处理第一列和最后一列
        for (int i = 1; i < board.length - 1; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }


        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '$';
            if (i > 0 && board[i - 1][j] == 'O') {
                dfs(board, i - 1, j);
            }
            if (j < board[i].length - 1 && board[i][j + 1] == 'O') {
                dfs(board, i, j + 1);
            }
            if (i < board.length - 1 && board[i + 1][j] == 'O') {
                dfs(board, i + 1, j);
            }
            if (j > 1 && board[i][j - 1] == 'O') {
                dfs(board, i, j - 1);
            }
        }
    }
}
