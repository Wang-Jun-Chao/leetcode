/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:51
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private int min = Integer.MAX_VALUE; // 记录树的最小深度
    private int cur = 0; // i当前处理的树的尝试

    /**
     * <pre>
     * 原题
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path from
     * the root node down to the nearest leaf node.
     *
     * 题目大意
     * 给定一棵两叉树求树的最小深度。
     *
     * 解题思路
     * 遍历法，对整个树进行遍历，找出最小的深度。
     * </pre>
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        depth(root);
        return min;
    }

    /**
     * 计算树的深度
     *
     * @param node 当前结点
     */
    private void depth(TreeNode node) {

        if (node == null) {
            min = cur;
            return;
        }

        cur++; // 当前处理的层次加1
        // 如果是叶节点，并且路径比记录的最小还小
        if (node.left == null && node.right == null && cur < min) {
            min = cur; // 更新最小值
        }
        // 处理左子树
        if (node.left != null) {
            depth(node.left);
        }

        // 处理右子树
        if (node.right != null) {
            depth(node.right);
        }

        cur--; // 还原

    }
}
