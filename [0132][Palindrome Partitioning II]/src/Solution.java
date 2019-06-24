/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-24 19:22
 **/
public class Solution {
    /**
     * <pre>
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return the minimum cuts needed for a palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output: 1
     * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
     *
     * 分析
     * 定义状态f(i,j) 表示区间[i,j] 之间最小的cut 数，则状态转移方程为
     * f(i; j) = min {f(i; k) + f(k + 1; j)} ; i  k  j; 0  i  j < n
     * 这是一个二维函数，实际写代码比较麻烦。
     * 所以要转换成一维DP。如果每次，从i 往右扫描，每找到一个回文就算一次DP 的话，就可以
     * 转换为f(i)= 区间[i, n-1] 之间最小的cut 数，n 为字符串长度，则状态转移方程为
     * f(i) = min {f(j + 1) + 1} ; i <= j < n TODO 怎么理解？
     * 一个问题出现了，就是如何判断[i,j] 是否是回文？每次都从i 到j 比较一遍？太浪费了，这
     * 里也是一个DP 问题。
     * 定义状态P[i][j] = true if [i,j] 为回文，那么
     * P[i][j] = str[i] == str[j] && P[i+1][j-1]
     *
     * https://www.cnblogs.com/grandyang/p/4271456.html
     * </pre>
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        final int n = s.length();

        int[] dp = new int[n];
        boolean[][] p = new boolean[n][];

        for (int i = 0; i < n; ++i) {
            dp[i] = i;
            p[i] = new boolean[n];

            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || p[j + 1][i - 1])) {
                    p[j][i] = true;
                    dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
