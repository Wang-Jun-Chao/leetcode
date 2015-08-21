import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 19:27
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Follow up for problem "Populating Next Right Pointers in Each Node".
     *
     * What if the given tree could be any binary tree? Would your previous solution still work?
     * Note:
     *
     * You may only use constant extra space.
     * For example,
     * Given the following binary tree,
     *      1
     *    /  \
     *   2    3
     *  / \    \
     * 4   5    7
     * After calling your function, the tree should look like:
     *      1 -> NULL
     *    /  \
     *   2 -> 3 -> NULL
     *  / \    \
     * 4-> 5 -> 7 -> NULL
     *
     * 题目大意：
     * 给你一棵二叉树，每个树节点中增加了一个next指针，指向了其同一层的相邻的右边的节点。将同层的结点都串起来
     *
     * 解题思路：
     * 对树进行层次遍历，将每一层串接起来
     * </pre>
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root != null) {
            // 保存结点
            List<TreeLinkNode> list = new LinkedList<>();
            // 当前处理的结点的前一个结点
            TreeLinkNode prev = null;
            // 当前处理的结点
            TreeLinkNode node;
            // 当前层剩余的结点个数
            int curr = 1;
            // 记录下一层的元素个数
            int next = 0;

            // 根结点入队
            list.add(root);

            // 队列非空
            while (list.size() > 0) {
                // 删除队首元素
                node = list.remove(0);
                // 当前层剩余数减少
                curr--;

                // 左子树非空，左子结点入队
                if (node.left != null) {
                    list.add(node.left);
                    next++;
                }

                // 右子树非空，右子结点入队
                if (node.right != null) {
                    list.add(node.right);
                    next++;
                }

                // 如果当前层处理完了
                if (curr == 0) {

                    // 对下一层的元素进行串接
                    Iterator<TreeLinkNode> iterable = list.iterator();
                    if (iterable.hasNext()) {
                        prev = iterable.next();
                        while (iterable.hasNext()) {
                            node = iterable.next();
                            prev.next = node;
                            prev = node;
                        }
                    }

                    // 更新当前层剩余的结点数
                    curr = next;
                    // 重新统计下层结点数
                    next = 0;
                }
            }
        }
    }
}
