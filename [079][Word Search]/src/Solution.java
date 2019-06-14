/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 07:19
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     *
     * For example,
     * Given board =
     * [
     *      ["ABCE"],
     *      ["SFCS"],
     *      ["ADEE"]
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     *
     * 题目大意：
     * 给定一个board字符矩阵，可以从任意一个点开始经过上下左右的方式走，每个点只能走一次，
     * 如果存在一条路走过的字符等于给定的字符串，那么返回true
     *
     * 解题思路：
     * 以每一个点作为起点，使用回溯法进行搜索
     * </pre>
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // 【注意我们假定输入的参数都是合法】

        // 访问标记矩阵，初始值默认会设置为false
        boolean[][] visited = new boolean[board.length][board[0].length];

        // 以每一个位置为起点进行搜索，找到一个路径就停止
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, i, j, word, new int[]{0})) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param board   字符矩阵
     * @param visited 访问标记矩阵
     * @param row     访问的行号
     * @param col     访问的列号
     * @param word    匹配的字符串
     * @param idx     匹配的位置，取数组是更新后的值可以被其它引用所见
     * @return
     */
    private boolean search(char[][] board, boolean[][] visited, int row, int col, String word, int[] idx) {
        // 如果搜索的位置等于字串的长度，说明已经找到找到匹配的了
        if (idx[0] == word.length()) {
            return true;
        }

        boolean hasPath = false;
        // 当前位置合法
        if (check(board, visited, row, col, word, idx[0])) {
            // 标记位置被访问过
            visited[row][col] = true;
            idx[0]++;
            // 对上，右，下，左四个方向进行搜索
            hasPath = search(board, visited, row - 1, col, word, idx ) // 上
                    || search(board, visited, row, col + 1, word, idx) // 右
                    || search(board, visited, row + 1, col, word, idx) // 下
                    || search(board, visited, row, col - 1, word, idx); // 左


            // 如果没有找到路径就回溯
            if (!hasPath) {
                visited[row][col] = false;
                idx[0]--;
            }
        }

        return hasPath;
    }

    /**
     * 判定访问的位置是否合法
     *
     * @param board   字符矩阵
     * @param visited 访问标记矩阵
     * @param row     访问的行号
     * @param col     访问的列号
     * @param word    匹配的字符串
     * @param idx     匹配的位置
     * @return
     */

    public boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int idx) {
        return row >= 0 && row < board.length // 行号合法
                && col >= 0 && col < board[0].length // 列号合法
                && !visited[row][col] // 没有被访问过
                && board[row][col] == word.charAt(idx); // 字符相等
    }
}
