import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 12:18
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     *
     * For example:
     * Given the following binary tree,
     *      1            <---
     *    /   \
     *   2     3         <---
     *    \     \
     *     5     4       <---
     * You should return [1, 3, 4].
     *
     *  题目大意：
     *  给定一个二叉树，想象自己站在树的右边，返回从下到下你能看到的节点的值。
     *
     * 解题思路：
     * 二叉树的层次遍历，每层按照从左向右的顺序依次访问节点，（每一层取最右边的结点）
     * </pre>
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (root != null) {
            Deque<TreeNode> deque = new LinkedList<>();
            // 当前层的结点数
            int current = 1;
            // 下一层的结点数
            int next = 0;
            TreeNode node;
            deque.addLast(root);
            while (deque.size() > 0) {
                // 取第一个结点
                node = deque.removeFirst();
                current--;

                // 添加非空的左结点
                if (node.left != null) {
                    next++;
                    deque.addLast(node.left);
                }

                // 添加非空的右结点
                if (node.right != null) {
                    next++;
                    deque.addLast(node.right);
                }

                // 如果当前层已经处理完了
                if (current == 0) {
                    // 保存此层的最右一个结点值
                    result.add(node.val);
                    // 设置下一层的元素个数
                    current = next;
                    next = 0;
                }
            }
        }

        return result;
    }
}
