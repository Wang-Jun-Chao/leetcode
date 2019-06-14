/**
 * Author: 王俊超
 * Date: 2015-06-17
 * Time: 21:24
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a string S, find the longest palindromic substring in S.
     * You may assume that the maximum length of S is 1000, and there
     * exists one unique longest palindromic substring.
     *
     * 题目大意：
     * 给定一个字符串S，找出它的最大的回文子串，你可以假设字符串的最大长度是1000，
     * 而且存在唯一的最长回文子串
     *
     * 解题思路：
     * 动态规划法，
     * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出：
     * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
     * 这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，因此需
     * 要求出基准情况才能套用以上的公式：
     *
     * a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
     * b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
     *
     * 有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n^2)的空间。
     * </pre>
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 0;
        String longest = null;

        int length = s.length();
        boolean[][] table = new boolean[length][length];

        // 单个字符都是回文
        for (int i = 0; i < length; i++) {
            table[i][i] = true;
            longest = s.substring(i, i + 1);
            maxLength = 1;
        }

        // 判断两个字符是否是回文
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }


        // 求长度大于2的子串是否是回文串
        for (int len = 3; len <= length; len++) {
            for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] && maxLength < len) {
                        longest = s.substring(i, j + 1);
                        maxLength = len;
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }

        return longest;
    }


}
