/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 17:45
 **/
public class Solution {
    /**
     * <pre>
     * Given a string, you need to reverse the order of characters in each word
     * within a sentence while still preserving whitespace and initial word order.
     *
     * Example 1:
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Note: In the string, each word is separated by single space and there will
     * not be any extra space in the string.
     * </pre>
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();

        int start = 0;
        int end = 0;
        while (start < chars.length) {
            // 找第一个非空白字符
            while (start < chars.length && chars[start] == ' ') {
                start++;
            }
            // 找第一个空白字符
            end = start + 1;
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }

            // 翻转字符串
            swap(chars, start, end - 1);
            start = end;
        }

        return new String(chars);
    }

    private void swap(char[] chars, int start, int end) {
        while (start < end) {
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            start++;
            end--;
        }
    }
}
