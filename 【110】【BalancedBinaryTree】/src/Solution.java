/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:53
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * 题目大意
     * 给定一棵平衡二叉树，判断它是否是高度平衡的。一棵高度平衡的二叉树是左右子树的高度相差不超过1，
     * 对其左右子树也是如此。
     *
     * 解题思路
     * 递归分治法求解。
     * </pre>
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 求树的高度
     *
     * @param n 树的根结点
     * @return 树的高度
     */
    private int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return 1;
        } else {
            int left = depth(n.left);
            int right = depth(n.right);
            return 1 + (left > right ? left : right);
        }
    }

}
