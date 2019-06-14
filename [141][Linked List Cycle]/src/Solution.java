/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:16
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a linked list, determine if it has a cycle in it.
     * Follow up:
     * Can you solve it without using extra space?
     *
     * 题目大意
     * 给定一个单链表，判断链表是否有环。
     *
     * 解题思路
     * 设置两个指针(fast, slow)，初始值都指向头，slow每次前进一步，fast每次前进二步，如果链表存在环，
     * 则fast必定先进入环，而slow后进入环，两个指针必定相遇
     * </pre>
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        return !(fast == null || fast.next == null);
    }
}
