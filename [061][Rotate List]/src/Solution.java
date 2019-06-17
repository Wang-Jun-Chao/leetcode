/**
 * Author: 王俊超
 * Date: 2015-07-21
 * Time: 18:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {

        if (head == null || n < 1) {
            return head;
        }

        int length = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            length++;
        }

        // 从左向右要，遍历的节点个数，即为新head的前一个节点
        n = length - n % length;

        // 首尾相连
        p.next = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        head = p.next;
        p.next = null;
        return head;
    }
}
