/**
 * https://leetcode.com/problems/longest-palindrome/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 04:08
 **/
public class Solution1 {
    /**
     * <pre>
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * Example:
     *
     * Input:
     * "abccccdd"
     *
     * Output:
     * 7
     *
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     * 思路
     * 1、先记录每个字符出现的次数
     * 2、取每个字符出现的最大的偶数
     * 3、如果还有剩下的单个字符，只取其中的一个
     * </pre>
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int[] counter = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counter[ch - 'A']++;
        }

        int result = 0;
        int left = 0;
        for (int value : counter) {
            if (value > 0) {
                if (value % 2 == 0) {
                    result += value;
                } else {
                    result += value - 1;
                    left = 1;
                }
            }
        }

        return result + left;
    }
}
