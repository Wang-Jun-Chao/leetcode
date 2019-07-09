import java.util.Objects;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 17:37
 **/
public class Solution {
    /**
     * <pre>
     * Given a non-empty string check if it can be constructed by taking a substring of it
     * and appending multiple copies of the substring together. You may assume the given
     * string consists of lowercase English letters only and its length will not exceed 10000.
     *
     *
     *
     * Example 1:
     *
     * Input: "abab"
     * Output: True
     * Explanation: It's the substring "ab" twice.
     * Example 2:
     *
     * Input: "aba"
     * Output: False
     * Example 3:
     *
     * Input: "abcabcabcabc"
     * Output: True
     * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
     * 思路：
     * 从[half, 1]到时如某个数可以被整除，假定其是s.substring(0, k)的子串的重复，进行验证
     * </pre>
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {

        if (s == null || s.length() < 2) {
            return false;
        }

        int i = s.length() / 2;
        while (i > 0) {
            if (s.length() % i == 0) {
                boolean repeated = true;
                for (int j = i; j < s.length(); j += i) {
                    // 如果不相等于，退出for循环
                    if (!equals(s.substring(0, i), s.substring(j, j + i))) {
                        repeated = false;
                        break;
                    }
                }
                if (repeated) {
                    return true;
                }
            }

            i--;
        }

        return false;
    }

    private boolean equals(String s, String t) {
        return Objects.equals(s, t);
    }
}
