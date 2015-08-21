/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:13
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private int result = 0; // 记录总的结果
    private int num = 0; // 记根到叶子的数字

    /**
     * <pre>
     * 原题
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
     * could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * Find the total sum of all root-to-leaf numbers.
     * For example,
     *
     *   1
     *  / \
     * 2   3
     *
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Return the sum = 12 + 13 = 25.
     * 题目大意
     * 给定一个二叉树，每个结点的值是0-9，根到叶子组成一个数字，求所有的根到叶子组成的数字的和。
     *
     * 解题思路
     * 采用回溯法。
     * </pre>
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        sum(root);
        return result;
    }

    private void sum(TreeNode root) {
        if (root != null) {
            num = num * 10 + root.val;

            // 已经到了根结点了
            if (root.left == null && root.right == null) {
                result += num;
            }

            sum(root.left);
            sum(root.right);
            num /= 10;
        }
    }
}
