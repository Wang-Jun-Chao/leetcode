/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:02
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a binary tree, flatten it to a linked list in-place.
     * For example,
     * Given
     *
     *      1
     *     / \
     *    2   5
     *   / \   \
     *  3   4   6
     *
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * 题目大意
     * 给定一棵二叉树，将它转成单链表，使用原地算法。
     *
     * 解题思路
     * 从根结点（root）找左子树（l）的最右子结点（x），将root的右子树（r）接到x的右子树上（x的右子树为空），
     * root的左子树整体调整为右子树，root的左子树赋空。
     * </pre>
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        head.right = root;
        TreeNode node = head;

        while (node.right != null) {
            node = node.right;
            if (node.left != null) {
                TreeNode end = node.left;
                while (end.right != null) {
                    end = end.right;
                }

                TreeNode tmp = node.right;

                node.right = node.left;
                node.left = null;
                end.right = tmp;
            }
        }

        head.right = null; // 去掉引用方便垃圾回收
    }
}
