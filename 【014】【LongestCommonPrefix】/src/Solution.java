/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:19
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * 题目大意
     * 写一个函数找出一个字串所数组中的最长的公共前缀。
     *
     * 解题思路
     * 第一步先找出长度最小的字符串，然后将这个字符串与其它的字符串相比找出最短的最公共前缀。
     * </pre>
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }

        if (strs.length == 0) {
            return "";
        }

        int min = Integer.MAX_VALUE;  // 记录最短的字符串的长度

        // 找短字符串的长度
        for (String str : strs) {

            if (str == null) {
                return null;
            }

            if (min > str.length()) {
                min = str.length();
            }
        }

        int i; // 记录最长前缀的字符数
        boolean flag;
        for (i = 0; i < min; i++) {
            flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                break;
            }
        }

        return strs[0].substring(0, i);
    }
}
