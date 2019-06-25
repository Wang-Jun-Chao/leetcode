/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-25 19:17
 **/
public class Solution2 {
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
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }
        return memo[0];
    }

    // 太慢
    public int numDecodings2(String s) {
        // 如是不是纯数字的字符串就返回0
        if (s == null || !s.matches("^\\d+$")) {
            return 0;
        }

        // 第一位以0开头，没有可以匹配的
        if (s.charAt(0) == '0') {
            return 0;
        }

        // 如果只一位
        if (s.length() == 1) {
            return handle(s);
        }

        // 如果有两位
        if (s.length() == 2) {
            int v = Integer.parseInt(s);
            // 如果拆成个一位的有几种可能
            int r = handle(s.substring(s.length() - 1));

            // 如是两位组成一个，1~26才可以算一种可能
            if (v > 0 && v < 27) {
                r++;
            }
            return r;
        }

        // 字符串长度大于3，f(s)=(0 or 1)*f(s-1) + (0 or 1)*f(s-2)
        // 对于f(s-1)，如果首位是0，取0
        // 对于f(s-2)，如果首位是0或者首两位的值小于1或者大于26，取0

        int v = numDecodings(s.substring(1));
        int t = Integer.parseInt(s.substring(0, 2));

        if (t > 0 && t < 27) {
            v += numDecodings(s.substring(2));
        }

        return v;
    }

    private int handle(String s) {
        return Integer.parseInt(s) == 0 ? 0 : 1;
    }
}