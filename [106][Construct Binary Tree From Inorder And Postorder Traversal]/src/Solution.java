
/**
 * Author: 王俊超
 * Date: 2015-06-23
 * Time: 10:05
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * 题目大意：
     * 给定一个中序遍历和后序遍历序列，构造一棵二叉树
     * 注意：
     * 树中没有重复元素
     *
     * 解题思路：
     * 后序遍历的最后一个元素就是树的根结点(值为r)，
     * 在中序遍历的序列中找值为r的位置idx，idx将中序遍历序列分为左右两个子树，
     * 对应可以将后序遍历的序列分在两个子树，递归对其进行求解
     * </pre>
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // 参数检验
        if (inorder == null || postorder == null || inorder.length == 0
                || inorder.length != postorder.length) {
            return null;
        }

        // 构建二叉树
        return solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 构建二叉树
     *
     * @param inorder   中序遍历的结果
     * @param x         中序遍历的开始位置
     * @param y         中序遍历的结束位置
     * @param postorder 后序遍历的结果
     * @param i         后序遍历的开始位置
     * @param j         后序遍历的结束位置
     * @return 二叉树
     */
    public TreeNode solve(int[] inorder, int x, int y, int[] postorder, int i, int j) {

        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            // 只有一个元素，（此时也有i=j成）
            if (x == y) {
                return new TreeNode(postorder[j]);
            }
            // 多于一个元素，此时也有i<j
            else if (x < y) {
                // 创建根结点
                TreeNode root = new TreeNode(postorder[j]);

                // 找根结点在中序遍历的下标
                int idx = x;
                while (idx < y && inorder[idx] != postorder[j]) {
                    idx++;
                }

                // 左子树非空，构建左子树
                int leftLength = idx - x;
                if (leftLength > 0) {
                    // i, i + leftLength - 1，前序遍历的左子树的起始，结束位置
                    root.left = solve(inorder, x, idx - 1, postorder, i, i + leftLength - 1);
                }

                // 右子树非空，构建右子树
                int rightLength = y - idx;
                if (rightLength > 0) {
                    // i + leftLength, j - 1，前序遍历的右子树的起始，结束位置
                    root.right = solve(inorder, idx + 1, y, postorder, i + leftLength, j - 1);
                }

                return root;
            }
        }

        return null;
    }
}
