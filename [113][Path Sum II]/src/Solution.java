import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:59
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private List<List<Integer>> result;
    private List<Integer> l;
    private int sum;
    private int curSum = 0;

    /**
     * <pre>
     * 原题
     * Given a binary tree and a sum, find all root-to-leaf paths where each path’s
     * sum equals the given sum.
     * For example:
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \    / \
     * 7    2  5   1
     *
     *  return
     *
     * [
     *  [5,4,11,2],
     *  [5,8,4,5]
     * ]
     *
     * 题目大意
     * 给定一棵二叉树和一个和，判断从树的根结点到叶子结点的所有结点的和是否等于给定的和，如果等于就记录这条路径。
     *
     * 解题思路
     * 对树进行遍历，并且使用回溯法进行求解。
     * </pre>
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new LinkedList<>();

        if (root != null) {
            this.sum = sum;
            l = new LinkedList<>();
            pathSum(root);
        }

        return result;
    }

    private void pathSum(TreeNode root) {
        if (root != null) {

            l.add(root.val);
            curSum += root.val;

            if (root.left == null && root.right == null && curSum == sum) {
                List<Integer> list = new LinkedList<>();
                for (Integer i : l) {
                    list.add(i);
                }

                result.add(list);
            }

            if (root.left != null) {
                pathSum(root.left);
            }

            if (root.right != null) {
                pathSum(root.right);
            }

            curSum -= root.val;
            l.remove(l.size() - 1); // 删除最后一个
        }
    }
}
