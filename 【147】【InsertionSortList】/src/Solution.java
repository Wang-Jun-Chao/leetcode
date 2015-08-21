/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:23
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Sort a linked list using insertion sort.
     *
     * 题目大意
     * 对一个单链表表进行插入排序
     *
     * 解题思路
     * 使用一个指针p指向未排好序的链表的第一个结点，在排序好的部分中找到找第一个大于等于q的前驱结点，
     * 将p对应的结点插入到正确位置，p重新指向未排好序的链表的第一个结点。直到链表完成排序好。
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        ListNode root = new ListNode(0); // 头结点
        root.next = head;
        ListNode p = head;
        ListNode q;
        ListNode r;

        while (p != null && p.next != null) {
            if (p.val <= p.next.val) {
                p = p.next;
            } else {
                q = p.next;
                p.next = q.next;

                r = root;
                // 找第一个大于等于q.val的前驱结点，因为在root.next到p之间必定存在这样的结点
                while (r.next.val <= q.val) {
                    r = r.next;
                }

                q.next = r.next;
                r.next = q;
            }
        }

        return root.next;
    }
}
