import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:44
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a binary tree, return the level order traversal of its nodes’ values.
     * (ie, from left to right, level by level).
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     *
     *    3
     *   / \
     *  9  20
     *    /  \
     *   15   7
     *
     * return its level order traversal as:
     *
     * [
     *  [3],
     *  [9,20],
     *  [15,7]
     * ]
     * 题目大意
     * 给定一个二叉树，输出它的每一层的结点。
     *
     * 解题思路
     * 使用两队列，一个保存当前处理的层，一个保存下一次要处理的层。只到每一层都处理完。
     * </pre>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> cur = new LinkedList<>();
        Deque<TreeNode> sub = new LinkedList<>();
        Deque<TreeNode> exc;

        TreeNode node;
        cur.addLast(root);

        while (!cur.isEmpty()) {
            List<Integer> layout = new LinkedList<>();
            while (!cur.isEmpty()) {
                node = cur.removeFirst();
                layout.add(node.val);

                if (node.left != null) {
                    sub.addLast(node.left);
                }

                if (node.right != null) {
                    sub.addLast(node.right);
                }
            }

            exc = cur;
            cur = sub;
            sub = exc;

            result.add(layout);
        }

        return result;
    }
}
