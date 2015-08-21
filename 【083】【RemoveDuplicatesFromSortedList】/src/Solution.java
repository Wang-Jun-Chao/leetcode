/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:45
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     *
     * 题目大意
     * 给定一个单链表，删除重复的元素，相同的只保留一个。
     *
     * 解题思路
     * 使用一个指针指向链表的头，如果下一个与当前的结点相等则删除，直到遇到一个不相同的，则指针指向这
     * 个新的结点，重复操作，直到所有的结点都处理完。
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode point;
        ListNode tail = head; // 指向新结点的尾部，开始时新链只有一个元素，就是链头

        if (head != null) {
            point = head.next; // 指向另一个链的头部
            while (point != null) { // 另一个链还未到末尾

                if (tail.val != point.val) { // 如果与尾节点不相同，就将不相同的节点链接到tail的下一个位置
                    tail.next = point;
                    tail = tail.next; // 重新指向链尾
                }

                point = point.next;
            }

            tail.next = null; // 链尾指向空
        }

        return head;
    }
}
