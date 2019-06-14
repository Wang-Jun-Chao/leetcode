/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:56
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private boolean stop = false; // 判断是否已经找到答案

    /**
     * <pre>
     * 原题
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals the given sum.
     * For example:
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \      \
     * 7    2      1
     *
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     *
     * 题目大意
     * 给定一棵二叉树和一个和，判断从树的根结点到叶子结点的所有结点的和是否等于给定的和，如果等于，
     * 就返回true，否则返回false。
     *
     * 解题思路
     * 对树进行遍历，并且使用回溯法进行求解。
     * </pre>
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        calculate(root, 0, sum);
        return stop;
    }

    /**
     * 计算根到叶子结点的和
     *
     * @param node 当前处理的节点
     * @param cur  从根节点到当前结点之前的所有节点和
     * @param sum  要求的和
     */
    private void calculate(TreeNode node, int cur, int sum) {
        if (!stop && node != null) { // 还没有找到答案，并且要处理的节点不为空

            // 如果是叶节点，就检查从根到当前叶节点的和是否为sum，如果是就说明已经找到，改变stop
            if (node.left == null && node.right == null && (node.val + cur == sum)) {
                stop = true;
            }

            // 如果是非叶节点，继续处理
            if (node.left != null) {
                calculate(node.left, cur + node.val, sum);
            }

            if (node.right != null) {
                calculate(node.right, cur + node.val, sum);
            }
        }
    }
}
