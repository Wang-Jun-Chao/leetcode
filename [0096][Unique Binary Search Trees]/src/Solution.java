/**
 * Author: 王俊超
 * Date: 2015-06-18
 * Time: 17:36
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
     * <p>
     * For example,
     * Given n = 3, there are a total of 5 unique BST's.
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1       1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * <p>
     * 递推公式
     * f(0) = 1
     * f(1) = 1
     * f(i) = f(0)f(i-1) + f(1)f(i-1) + ... + f(i-1)f(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        if (n <= 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;


        // 求f(2)...f(n)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }

        }
        return result[n];
    }
}
