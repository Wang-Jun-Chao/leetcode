/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 17:23
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * return 1->4->3->2->5->NULL.
     * Note:
     * Given m, n satisfy the following condition:
     * 1 ≤ m ≤ n ≤ length of list.
     *
     * 题目大意
     * 给定一个单链表，将第m到第n个之间的元素进行转。
     * 给定的n和m都是合法的，使用原地方法进行解决（使用常量辅助空间）
     *
     * 解题思路
     * 先找到第一个要反转的元素的前驱（prev），再计算要进行反转的元素个数，对元素进行头插法，
     * 插在prev后面，同时保持链表不断开。
     * </pre>
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode root = new ListNode(0);
        ListNode p = root;
        root.next = head;

        for (int i = 1; i < m && p != null; i++) {
            p = p.next;
        }

        if (p != null) {
            ListNode q = p.next;
            ListNode r;

            // 如果m为负数就认为是从第一个开始交换
            if (m < 1) {
                m = 1;
            }

            n = n - m + 1; // n为要换的结点数目
            // 有两个结点时才要使用尾插法，尾插的个数为n-1
            for (int i = 1; i < n && q.next != null; i++) {
                // 为要进行尾插的结点
                r = q.next;

                // 在q结点的后面进行尾插操作
                q.next = r.next;
                r.next = p.next;
                p.next = r;
            }

            head = root.next;
        }

        return head;
    }
}
