/**
 * Author: 王俊超
 * Date: 2015-06-23
 * Time: 07:16
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a singly linked list where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     *
     * 题目大意：
     * 给定一个升序的单链表，将它转换成一颗高度平衡的二叉树
     *
     * 解题思路：
     * 解法一：将单链表中的值存入一个数组中，通过数组来构建二叉树，算法时间复杂度是：O(n)，空间复杂度是：O(n)
     * 解法二：采用递归的方式，
     *      （一）找中间结点，构建根结点，
     *      （二）中间结点左半部分构建左子树，
     *      （三）中间结点的右部分构建右子树
     * 题采用第二种解法
     * </pre>
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        // 如果链表为空就直接返回null
        if (head == null) {
            return null;
        }

        // 链表只有一个结点
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 快速移动结点，每次移动两个位置
        ListNode fast = head.next.next;
        // 记录中间结点
        ListNode mid = head;
        // 找中间结点
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        // 以中间结点的下一个结点作为根结点
        TreeNode root = new TreeNode(mid.next.val);
        // 构建右子树
        root.right = sortedListToBST(mid.next.next);
        // 记录链表要断开的点
        ListNode midNext = mid.next;
        // 断开单链表（会破坏原来单链表的结构）
        mid.next = null;
        // 构建左子树
        root.left = sortedListToBST(head);
        // 重新将链表接好
        mid.next = midNext;
        // 返回结果
        return root;
    }
}
