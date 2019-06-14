/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:18
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * Follow up:
     * Can you solve it without using extra space?
     *
     * 题目大意
     * 给定一个单链表，如果它有环，返回环入口的第一个节点，否则返回null
     *
     * 解题思路
     * 先判断链表是否有环，使用快（fast）慢指针（slow），解法见【141】【LinkedListCycle】，
     * 如果没有环就返回null，如果有环，有fast=slow，就让让slow重新指向链表头，然后两个指针每次同时移动一个位置，
     * 直到两链表相遇，相遇点就是环的入口结点。
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
