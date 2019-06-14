/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:37
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a linked list, swap every two adjacent nodes and return its head.
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     *
     * 题目大意
     * 给定一个单链表，成对交换两个相邻的结点。算法法应该做常量辅助空间，不能改结点的值，只能交换结点。
     *
     * 解题思路
     * 使用一个头结点root来辅助操作，对要进行交换的链表，每两个的位置进行交换，
     * 并且把交换后的结点接到root的链表上，直到所有的结点都处理完。
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0); // 头结点
        node.next = head;

        // p指向新的链表的尾结点
        ListNode p = node;
        ListNode tmp;

        // 每两个进行操作
        while (p.next != null && p.next.next != null) {
            // 记录下一次要进行处理的位置
            tmp = p.next.next;
            // 下面三句完成两个结点交换
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
            // 指向返回链表的新的尾结点
            p = tmp.next;
        }

        head = node.next;
        node.next = null;

        return head;
    }
}
