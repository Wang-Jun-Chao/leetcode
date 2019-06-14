import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-23
 * Time: 13:24
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its zigzag level order traversal as:
     * [
     *      [3],
     *      [20,9],
     *      [15,7]
     * ]
     *
     * 题目大意：
     * 给定一棵二叉树，从顶向下，进行Z字形分层遍历，即：如果本层是从左向右的，下层就是从右向左
     *
     * 解题思路：
     * 二叉树分层遍历进行改进，使用两个栈来进行
     * </pre>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        // 遍历标志，0表示从左到右，1表示从右到左
        int flag = 0;
        TreeNode node;
        // 记录每一层的元素
        List<Integer> lay = new LinkedList<>();
        // 双向队列，当作栈来使用，记录当前层待处理结点
        Deque<TreeNode> stack = new LinkedList<>();
        // 记录下一层待处理结点
        Deque<TreeNode> nextStack = new LinkedList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            // 删除栈顶元素
            node = stack.removeLast();

            // 结果入队
            lay.add(node.val);

            // 如果当前是从左到右遍历，按左子树右子树的顺序添加
            if (flag == 0) {
                if (node.left != null) {
                    nextStack.addLast(node.left);
                }

                if (node.right != null) {
                    nextStack.addLast(node.right);
                }
            }
            // 如果当前是从右到左遍历，按右子树左子树的顺序添加
            else {
                if (node.right != null) {
                    nextStack.addLast(node.right);
                }

                if (node.left != null) {
                    nextStack.addLast(node.left);
                }
            }

            // 当前层已经处理完了
            if (stack.isEmpty()) {
                Deque<TreeNode> temp = nextStack;
                nextStack = stack;
                stack = temp;

                // 标记下一层处理的方向
                flag = 1 - flag;
                // 保存本层结果
                result.add(lay);
                // 创建新的链表处理下一层的结果
                lay = new LinkedList<>();
            }
        }

        return result;
    }
}
