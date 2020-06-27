/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:21
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     * Example 1:
     *
     * Given 1->2->3->4, reorder it to 1->4->2->3.
     * Example 2:
     *
     * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
     *
     * 解题思路：
     * 1、找到链表的中间结点
     * 2、如果链表有奇数个点，就将中间结点之后的链表进行拆分，否则就
     *
     * </pre>
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode fast = head;
        // 找中间结点的前驱结点
        ListNode slow = root;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 说明有偶数个节点
        if (fast == null) {
            root.next = slow.next;
            slow.next = null;

        } else { // 有奇数个点
            slow = slow.next;
            root.next = slow.next;
            slow.next = null;
        }

        // 第一个不需要进行头插法操作
        fast = root.next;
        ListNode tmp;
        // 将后半部分逆序
        while (fast.next != null) {
            tmp = fast.next;
            fast.next = tmp.next;
            tmp.next = root.next;
            root.next = tmp;
        }

        slow = head;
        fast = root.next;

        while (fast != null) {
            tmp = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = slow.next.next;
            fast = tmp;
        }
    }
}
