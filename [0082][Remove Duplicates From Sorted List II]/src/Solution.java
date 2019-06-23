/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:43
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     *
     * 题目大意
     * 给定一个排好序的单链表，删除所有重复的元素。只留下只有一个值的元素。
     *
     * 解题思路
     * 给链表接上一个辅助结点root，root接到原来的头部，引用这个头部和辅助的指针，对重重的元素进行删除。
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        // 头结点
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = head;
        // 记录最后一个没有重复的元素，开始指向头结点
        ListNode q = root;

        // 元素重复个数
        int delta = 0;

        while (p != null && p.next != null) {
            // 如果相邻两个数相同
            if (p.val == p.next.val) {
                delta++;
                // 移动到下一个结点
                p = p.next;
            }
            // 如果相邻两个结点不相同
            else {
                // 值为p.val的结点没有重复
                if (delta == 0) {
                    // 链接到没有复的元素
                    q.next = p;
                    // 指向最后一个未重复的元素
                    q = p;
                    // 移动到下一个结点
                    p = p.next;
                }
                // 值为p.val的结点有重复
                else {
                    // 移动到下一个元素
                    p = p.next;
                    // 去掉重复的元素
                    q.next = p.next;
                    // 元素重复个数设置为0
                    delta = 0;
                }
            }
        }

        // 如果最后一个元素是复的就去掉
        if (delta != 0) {
            q.next = null;
        }
        // 如果没有重复就开链接到表尾
        else {
            q.next = p;
        }

        return root.next;
    }
}
