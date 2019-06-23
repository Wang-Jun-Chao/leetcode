/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:10
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a string, determine if it is a palindrome, considering only
     * alphanumeric characters and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * Note:
     * Have you consider that the string might be empty? This is a good
     * question to ask during an interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     *
     * 题目大意
     * 给定一个字符串，判断它是否是回文字符串，仅考虑字母，并且忽略大小写。
     *
     * 解题思路
     * 使用首尾指针，分别找到第一个符合条件的位置，进行比较，如果相等就进行下一组比较，
     * 不相等就返回false，直到所有的字母都处理完。
     * </pre>
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        int delta = 'A' - 'a';
        char l;
        char r;

        while (left < right) {
            while (left < s.length() && !isAlphanumericCharacters(s.charAt(left))) { // 从左向右找数字与字母
                left++;
            }

            while (right >= 0 && !isAlphanumericCharacters(s.charAt(right))) { // 从右向左找数字与字母
                right--;
            }

            if (left < right) {
                l = s.charAt(left);
                r = s.charAt(right);
                if (l == r || l - r == delta || r - l == delta) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 判断是否是字母或者数字
     *
     * @param c 待判断的数字
     * @return 判断结果
     */
    private boolean isAlphanumericCharacters(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
