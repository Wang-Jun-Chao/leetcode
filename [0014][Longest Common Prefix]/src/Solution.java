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

        // 记录最短的字符串的长度
        int min = Integer.MAX_VALUE;

        // 找短字符串的长度
        String result = "";
        for (String str : strs) {

            if (str == null || str.length() == 0) {
                return "";
            }

            if (min > str.length()) {
                min = str.length();
                result = str;
            }
        }

        for (String s : strs) {
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) != s.charAt(i)) {
                    result = result.substring(0, i);
                }
            }
        }

        return result;
    }
}
