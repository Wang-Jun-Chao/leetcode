/**
 * Author: 王俊超
 * Date: 2015-06-18
 * Time: 10:43
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * Given a binary tree
     *      struct TreeLinkNode {
     *          TreeLinkNode *left;
     *          TreeLinkNode *right;
     *          TreeLinkNode *next;
     *      }
     * Populate each next pointer to point to its next right node. If there is no next right node,
     * the next pointer should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     *
     * Note:
     *      - You may only use constant extra space.
     *      - You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
     *        and every parent has two children).
     *
     * For example,
     * Given the following perfect binary tree,
     *      1
     *    /  \
     *   2    3
     *  / \  / \
     * 4  5  6  7
     *
     * After calling your function, the tree should look like:
     *
     *      1 -> NULL
     *    /  \
     *   2 -> 3 -> NULL
     *  / \  / \
     * 4->5->6->7 -> NULL
     *
     * 基本思路：
     * 将树的每一层节点用next串起来。这样每一层也会形成一个单链表。
     * 而每层的链表头，则是，根的左孩子，左孩子，左孩子。
     * 利用双循环，外层循环，沿着根的左孩子，一直向下。
     * 内层循环，负责将下一层的节点串起来。
     *
     * 即，将自己右孩子放到左孩子的next上，而右孩子，则可通过自己的next指针，找到右邻居。
     * </pre>
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {

        TreeLinkNode node;
        // 题中假设了输入的树是一棵完全叉树
        // 第一个循环用来处理整个树
        // root.left != null如果不用，则处理到最后第一个没有左右子树的结点会出错
        while (root != null && root.left != null) {
            // 每个root表示第一个层的第一个结点
            // node记录每一个层的第一个结点
            node = root;

            // 处理每个层
            while (node != null) {
                // 表示连接的是同一个结点的下的两子结点
                node.left.next = node.right;
                // node不是某个层的最后一个结点
                if (node.next != null) {
                    // 将这个结点的右子结点连接到这个结点的同层相邻结点的左子结点上
                    node.right.next = node.next.left;
                }

                // 移动到同层的下一个结点
                node = node.next;
            }

            // 移动到下一层的第一个结点
            root = root.left;
        }

    }
}
