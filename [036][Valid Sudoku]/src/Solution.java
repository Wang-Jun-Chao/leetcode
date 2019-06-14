/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:59
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
     * The Sudoku board could be partially filled, where empty cells are filled
     * with the character '.'.
     *
     * A partially filled sudoku which is valid.
     * Note:
     * A valid Sudoku board (partially filled) is not necessarily solvable.
     * Only the filled cells need to be validated.
     *
     * 题目大意
     * 验证一个数独棋盘是否合法，数独棋盘的验证规则见链接对应的页面。
     * 数独棋盘是部分填满的，空的位置使用点来代替。
     * 注意：合法的棋盘不一定要求的可解的，只要填充的数字满足要求就可以。
     *
     * 解题思路
     * 先对行进行检查，再对列进行检查，最后检查３*３的方格。
     * </pre>
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // .的ASCII值是46，0的ASCII值是48，/的ASCII值是47
        int number = board[0].length;
        int[] record = new int[10 + 2]; //保存.到9的值，保存数据的位置在[2, 10]
        boolean isValid;
        reset(record);

        // 对行进行检查
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                record[board[i][j] - '.']++;
            }

            if (!check(record)) { // 如是检查失败
                return false;
            } else { // 检查成功重置棋盘
                reset(record);
            }
        }

        // 对列进行检查
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                record[board[j][i] - '.']++;
            }

            if (!check(record)) { // 如是检查失败
                return false;
            } else { // 检查成功重置棋盘
                reset(record);
            }
        }

        // 检查3*3方块
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                for (int k = i * 3; k < (i + 1) * 3; k++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        record[board[k][l] - '.']++;
                    }
                }

                if (!check(record)) { // 如是检查失败
                    return false;
                } else { // 检查成功重置棋盘
                    reset(record);
                }
            }
        }
        return true;
    }

    private void reset(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }


    }

    /**
     * 检查棋盘一行，一列，或者3*3的方格是否合法，如果1-9中的数字个数大于1就不合法
     *
     * @param a 验证数字
     * @return 返回结果
     */
    private boolean check(int[] a) {
        for (int i = 2; i < a.length; i++) {
            if (a[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
