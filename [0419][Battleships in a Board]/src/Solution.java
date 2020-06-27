/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 13:23
 **/
public class Solution {
    public int countBattleships(char[][] board) {

        if (board == null || board.length < 1) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 当前位置是X
                if (board[i][j] == 'X') {
                    // 如果左边一个并且上面一个不是X，说明是战舰的起点
                    // 考虑边界情况
                    if (i > 0 && j > 0 && board[i - 1][j] != board[i][j] && board[i][j - 1] != board[i][j]) {
                        result++;
                    } else if (i > 0 && j == 0 && board[i - 1][j] != board[i][j]) {
                        result++;
                    } else if (i == 0 && j > 0 && board[i][j - 1] != board[i][j]) {
                        result++;
                    } else if (i == 0 && j == 0) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
