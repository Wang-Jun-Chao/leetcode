/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-25 19:17
 **/
public class Solution {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     * <p>
     * Example 1:
     * <p>
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     * Example 2:
     * <p>
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int prev = 0;
        int cur = 1;
        // 长度为n 的字符串，有n+1 个阶梯
        for (int i = 1; i <= s.length(); ++i) {
            if (s.charAt(i - 1) == '0') {
                cur = 0;
            }
            if (i < 2 || !(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                prev = 0;
            }

            int tmp = cur;
            cur = prev + cur;
            prev = tmp;
        }
        return cur;
    }

}