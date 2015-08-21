/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:30
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a linked list, remove the nth node from the end of list and return its head.
     * For example,
     *
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     *
     * 题目大意
     * 删除单链表的倒数第Ｎ个结点，注意：输入的Ｎ都是合法，在一次遍历中完成操作。
     *
     * 解题思路
     * 先让一个指针走找到第N个节点，然后再让一个指针指向头结点，然后两具指针一起走，
     * 直到前一个指针直到了末尾，后一个指针就是倒数第N+1个结点，删除倒数第N个结点就可以了。
     * </pre>
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pa = head;
        ListNode pb = head;

        // 找到第n个结点
        for (int i = 0; i < n && pa != null; i++) {
            pa = pa.next;
        }


        if (pa == null) {
            head = head.next;
            return head;
        }

        // pb与pa相差n-1个结点
        // 当pa.next为null，pb在倒数第n+1个位置
        while (pa.next != null) {
            pa = pa.next;
            pb = pb.next;
        }

        pb.next = pb.next.next;
        return head;
    }
}
