/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:06
 **/
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    // 尝试1到9的数字
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            // 将字符放入单元格
                            board[i][j] = c;

                            // 如果字符可以放入单元格返回true
                            if (solve(board)) {
                                return true;
                            } else { // 如果字符不能放入单元格就是还原成点号
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 检查行
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            // 检查列
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            // 检查3*3的单元格
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
