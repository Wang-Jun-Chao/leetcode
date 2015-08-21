/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:40
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given two binary trees, write a function to check if they are equal or not.
     * Two binary trees are considered equal if they are structurally identical and
     * the nodes have the same value.
     *
     * 题目大意
     * 给定两个二叉树，判断这两棵树是否相等。
     * 仅当两棵树的结构相同，结点值都相等时都会相等。
     *
     * 解题思路
     * 使用递归进行求解，先判断当前结点值是否相等，如果相等就再比较其左右子树，
     * 只有当所有的结点都相等才相等。
     * </pre>
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p == null && q != null) {
            return false;
        }


        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
