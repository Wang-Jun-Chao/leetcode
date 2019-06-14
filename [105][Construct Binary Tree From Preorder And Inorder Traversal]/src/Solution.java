/**
 * Author: 王俊超
 * Date: 2015-06-23
 * Time: 14:04
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * 题目大意：
     * 给定一个前序和中序遍历序列，构建一个二叉树
     * 注意：
     *   - 二叉树中元素重复元素
     *
     * 解题思路：
     * 前序遍历第一个元素是根结点（k），在中序遍历序列中找值为k的下标idx
     * idx将中序遍历序列分成左右子树，对前序遍历序列也一样，可进行递归操作
     * </pre>
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 参数校验
        if (preorder == null || inorder == null || preorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        return solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 构建二叉树，数据输入的正确性由输入数据自己保证
     *
     * @param preorder 先序遍历的结果
     * @param x        先序遍历的开始位置
     * @param y        先序遍历的结束位置
     * @param inorder  中序遍历的结果
     * @param i        中序遍历的开始位置
     * @param j        中序遍历的结束位置
     * @return 二叉树的根结点
     */
    public TreeNode solve(int[] preorder, int x, int y, int[] inorder, int i, int j) {

        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            // 只有一个元素
            if (x == y) {
                return new TreeNode(preorder[x]);
            } else if (x < y) {
                // 记录根结点的索引
                int idx = i;
                while (idx <= j && inorder[idx] != preorder[x]) {
                    idx++;
                }

                // 创建根结点
                TreeNode root = new TreeNode(inorder[idx]);

                // 左子树的结点个数
                int leftLength = idx - i;
                //
                if (leftLength > 0) {
                    // x + 1, x + leftLength：左子树起始和结束位置
                    root.left = solve(preorder, x + 1, x + leftLength, inorder, i, idx - 1);
                }

                // 右子树的结点个数
                int rightLength = j - idx;
                if (rightLength > 0) {
                    // x + leftLength + 1, y：右子树起始和结束位置
                    root.right = solve(preorder, x + leftLength + 1, y, inorder, idx + 1, j);
                }
                return root;
            }
        }

        return null;
    }
}
