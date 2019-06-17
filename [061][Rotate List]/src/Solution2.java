/**
 * Author: 王俊超
 * Date: 2015-07-21
 * Time: 18:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution2 {
    public ListNode rotateRight(ListNode head, int n) {

        if (head == null || n < 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root;
        ListNode q = root;

        // 旋转的位置可能比链表长
        int count = 0;
        for (int i = 0; i <= n; i++) {
            p = p.next;
            count++;
            if (p == null) {
                // 链表中除头结点后数据个数
                count--;
                // 实际要位置的位数
                n = n % count;
                // 为重新开始位移做准备
                i = 0;
                p = head;
            }
        }

        // 找到第一个要交换的结点的前驱
        // q为第一个要交换的结点的前驱
        while (p != null) {
            p = p.next;
            q = q.next;

        }

        p = q;
        q = root;
        // 有要位移的结点
        if (p != null && p.next != null) {
            ListNode node;
            while (p.next != null) {
                // 摘除结点
                node = p.next;
                p.next = node.next;
                // 接上结点
                node.next = q.next;
                q.next = node;
                // 最后一个移动的节点
                q = node;
            }
        }

        return root.next;
    }
}
