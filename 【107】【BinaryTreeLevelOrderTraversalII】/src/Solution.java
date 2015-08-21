import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 18:49
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a binary tree, return the bottom-up level order traversal of its nodes’ values.
     * (ie, from left to right, level by level from leaf to root).
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its bottom-up level order traversal as:
     *
     * [
     *  [15,7],
     *  [9,20],
     *  [3]
     * ]
     *
     * 题目大意
     * 给定一棵二叉树自底向下进行层序遍历。
     *
     * 解题思路
     * 对树进行层序遍历，每层的结果放在结果链表的头部。
     * </pre>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> cur = new LinkedList<>();
        Deque<TreeNode> nxt = new LinkedList<>();
        Deque<TreeNode> exc = new LinkedList<>();

        TreeNode tmp;

        cur.add(root);
        while (!cur.isEmpty()) {
            List<Integer> layout = new ArrayList<>();

            while (!cur.isEmpty()) {
                tmp = cur.remove();

                if (tmp.left != null) {
                    nxt.add(tmp.left);
                }

                if (tmp.right != null) {
                    nxt.add(tmp.right);
                }

                layout.add(tmp.val);
            }

            exc = cur;
            cur = nxt;
            nxt = exc;

            list.add(0, layout);
        }

        return list;
    }
}
