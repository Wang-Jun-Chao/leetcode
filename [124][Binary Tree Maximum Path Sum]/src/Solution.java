/**
 * Author: 王俊超
 * Date: 2015-06-25
 * Time: 09:00
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    // 记录最大的路径和
    private int max;
    // 记录当前的路径和
    private int cur;

    /**
     * <pre>
     * Given a binary tree, find the maximum path sum.
     * The path may start and end at any node in the tree.
     * For example:
     * Given the below binary tree,
     *   1
     *  / \
     * 2   3
     * Return 6.
     *
     * 题目大意：
     * 计算二叉算的最大路径和，路径的起始和终点可以在任意结点
     *
     *
     * </pre>
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {


        if (root == null) {
            throw new IllegalArgumentException();
        }

        max = Integer.MIN_VALUE;
        cur = 0;
        maxPathSumHelper(root);
        return max;
    }

    public void maxPathSumHelper(TreeNode root) {
        if (root != null) {
            cur += root.val;

            if (max < cur) {
                max = cur;
            }

            maxPathSumHelper(root.left);
            maxPathSumHelper(root.right);
        }
    }

}
