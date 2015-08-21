/**
 * Author: 王俊超
 * Date: 2015-06-18
 * Time: 17:36
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
     *
     * For example,
     * Given n = 3, there are a total of 5 unique BST's.
     *  1         3     3      2      1
     *   \       /     /      / \      \
     *   3     2     1       1   3      2
     *  /     /       \                 \
     * 2     1         2                 3
     *
     * 递推公式
     * f(k)*f(n-1-k)：f(k)表示根结点左子树有k个结点，其有的形状是f(k)，f(n-1-k)表示右子树有n-1-k个结点
     *
     * f(n) = 2*f(n-1) + f(1)*f(n-2) + f(2)f(n-3) + f(3)f(n-4) + ... +f(n-2)*f(1)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;


        // 求f(2)...f(n)
        for (int i = 2; i <= n; i++) {
            // 求f(i)
            result[i] = 2 * result[i - 1];
            for (int j = 1; j <= i - 1 ; j++) {
                result[i] += result[j]*result[i - 1 -j];
            }

        }
        return result[n];
    }
}
