/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 09:28
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an input string, reverse the string word by word.
     *
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * 题目大意：
     * 给定一个字符串，将其反转，其的字词不转
     *
     * 解题思路：
     * 先对整个字符串反转，再将每个单词进行反转
     * </pre>
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        // 字符压缩
        int realLength = compressWhiteSpace(chars);

        // 交换整个字符串
        swapRange(chars, 0, realLength - 1);

        // 记录单词的起点
        int start = 0;
        // 记录单词的终点
        int end;

        while (start < realLength) {
            // 从start位置开始找第一个非空白字符
            while (start < realLength && chars[start] == ' ') {
                start++;
            }

            end = start + 1;
            // 找第一个空白字符
            while (end < realLength && chars[end] != ' ') {
                end++;
            }

            // 反转字符
            swapRange(chars, start, end - 1);
            // 记录新的开始位置
            start = end;
        }
        return new String(chars, 0, realLength);
    }

    /**
     * 对字符数组的的空白字符进行压缩
     *
     * @param chars 字符数组
     * @return 新的长度
     */
    public int compressWhiteSpace(char[] chars) {

        if (chars == null || chars.length == 0) {
            return 0;
        }

        // 放在字符的位置
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            // 从i位置开始找第一个非空白字符
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }

            // 已经处理完了
            if (i >= chars.length) {
                break;
            }

            // 从i位置开始处理非空白字符，直到遇到空白字符
            // 就是处理一个单词
            while (i < chars.length && chars[i] != ' ') {
                chars[pos] = chars[i];
                pos++;
                i++;
            }

            // 处理完一个单词要空一格，最后一个单词不有多空一格【A】
            if (pos < chars.length) {
                // 填充空格
                chars[pos] = ' ';
            }

            pos++;
        }

        // 说明字符串中只有空白字符
        if (pos == 0) {
            return 0;
        } else {
            // 减一就是要去掉多余的一个空格，见【A】
            return pos - 1;
        }

    }

    /**
     * 反转字字数数组中[x, y]位置的字符
     *
     * @param chars 字符数组
     * @param x     x位置
     * @param y     y位置
     */
    public void swapRange(char[] chars, int x, int y) {
        for (; x < y; x++, y--) {
            swap(chars, x, y);
        }
    }

    /**
     * 交换数组中x,y两个位置的单词
     *
     * @param chars 字符数组
     * @param x     x位置
     * @param y     y位置
     */
    public void swap(char[] chars, int x, int y) {
        char z = chars[x];
        chars[x] = chars[y];
        chars[y] = z;
    }
}
