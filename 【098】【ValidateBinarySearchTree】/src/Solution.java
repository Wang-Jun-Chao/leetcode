import java.util.Stack;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:37
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private Stack<Integer> stack;

    /**
     * <pre>
     * 原题
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * Assume a BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node’s key.
     * The right subtree of a node contains only nodes with keys greater than the node’s key.
     * Both the left and right subtrees must also be binary search trees.
     *
     * 题目大意
     * 验证二叉搜索树
     *
     * 解题思路
     * 对二叉搜索树进行中序遍历，结果按顺序保存起来，对于二叉搜索树中序遍历其结果有
     * 一个从小到大的排列的序列，并且没有重重元素，由此可以判断一棵树是否是二叉搜索树。
     * </pre>
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        stack = new Stack<>();
        inOrder(root);

        int i = stack.pop();
        int j;
        while (!stack.isEmpty()) {
            j = stack.pop();
            if (i <= j) {
                return false;
            }

            i = j;
        }

        return true;
    }

    /**
     * 如果是一棵二叉查找树必必是有序的
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            stack.push(root.val);
            inOrder(root.right);
        }
    }
}
