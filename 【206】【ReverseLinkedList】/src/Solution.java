/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 11:17
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Reverse a singly linked list.
     * 反转单链表
     * 使用头插法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 头结点
        ListNode root = new ListNode(0);
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = root.next;
            root.next = head;
            head = nextNode;
        }

        return root.next;
    }

    /**
     * TODO 使用递归解法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }

        reverseList2(head.next).next = head;

        return null;
    }
}
