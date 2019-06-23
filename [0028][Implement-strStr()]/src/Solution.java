/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:45
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Implement strStr().
     * Returns the index of the first occurrence of needle in haystack, or -1
     * if needle is not part of haystack.
     *
     * 题目大意
     * 实现实现strStr()函数，判断一个字符串在另一个字符串中出现的位置。如果不匹配就返回-1。
     *
     * 解题思路
     * 使用KMP算法进行实现
     * </pre>
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        if ("".equals(haystack)) {
            if ("".equals(needle)) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if ("".equals(needle)) {
                return 0;
            }
        }


        return kmpIndex(haystack, needle);
    }

    private int kmpIndex(String haystack, String needle) {


        int i = 0;
        int j = 0;
        int[] next = next(needle);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] next(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        int k = needle.length() - 1;
        while (i < k) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                if (needle.charAt(i) != needle.charAt(j)) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }

            } else {
                j = next[j];
            }
        }

        return next;
    }
}
