/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-19 14:28
 **/
public class Solution {
    /**
     * <pre>
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * Example 1:
     *
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * Example 2:
     *
     * Input: -1->5->3->4->0
     * Output: -1->0->3->4->5
     *
     * 使用链表的归并排序可以解决
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head;
        // 记录前驱
        ListNode r = null;

        // 将链表分害割成两半
        while (p != null && p.next != null) {
            p = p.next.next;
            r = q;
            q = q.next;
        }

        r.next = null;

        // 两个链接分别进行排序
        ListNode h1 = mergeSort(head);
        ListNode h2 = mergeSort(q);

        return merge(h1, h2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }

        return head.next;
    }
}
