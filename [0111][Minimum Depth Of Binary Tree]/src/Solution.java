/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:51
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
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
        return minDepth(root, false);
    }

    public int minDepth(TreeNode root, boolean hasBrother) {
        if (root == null) {
            // 自己为null，兄弟不为null，上层有子结点，说明当前还没有找到最小层
            // 没有兄弟，说明遍历到当前时，局部最小层已经找到
            return hasBrother ? Integer.MAX_VALUE : 0;
        }

        return 1 + Math.min(minDepth(root.left, root.right != null),
                minDepth(root.right, root.left != null));
    }

}
