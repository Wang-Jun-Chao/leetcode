/**
 * Author: 王俊超
 * Date: 2015-06-30
 * Time: 21:20
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a linked list, reverse the nodes of a linked list k at a time
     * and return its modified list.
     *
     * If the number of nodes is not a multiple of k then left-out nodes
     * in the end should remain as it is.
     *
     * You may not alter the values in the nodes, only nodes itself may
     * be changed.
     *
     * Only constant memory is allowed.
     *
     * For example,
     * Given this linked list: 1->2->3->4->5
     * For k = 2, you should return: 2->1->4->3->5
     * For k = 3, you should return: 3->2->1->4->5
     *
     * 题目大意：
     * 给定一个单链表，和一个分组数K，每K个结点进行反转，如果最后的结点数不足K个就
     * 保持原来的链接顺序不变。
     *
     * 解题思路：
     *
     * 用一个指针记录链接好的链表的最后一个结点（tail），
     * 用一个指针记录上一次链接好的部分的最后一个结点（head）
     * 对未链表的结点在head处进行尾插法，插k个元素，再将head移动到tail处，
     * tail重新记录链表的尾结点，直到所有的元素都进行了操作。
     * 如果最后的一组元素不足k个，因为进行过尾插法，所以还要进行还原，
     * 对最后的head元素进行尾插法就可以了
     *
     * </pre>
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        // 分组的头一个元素的前驱
        ListNode groupHead = root;
        // 当前要处理的结点
        ListNode curr = head;
        // 处理好的链表的尾结点
        ListNode groupTail = head;
        // 当前要处理的结点的后继
        ListNode next;

        // 对每个组，处理了多少个结点
        int count = 0;


        while (curr != null) {

            // 如果是分组的第一个元素就记录它
            if (count == 0) {
                groupTail = curr;
            }

            // 记录处理的元素个数
            count++;
            // 记录下一个待处理结点
            next = curr.next;
            // 进行尾插法操作
            curr.next = groupHead.next;
            groupHead.next = curr;
            curr = next;

            // 已经处理完了k个结点，分组头的前驱移动到最后一个链接好的结点
            if (count == k) {
                groupHead = groupTail;
                // 计数器归零
                count = 0;
            }
        }


        // 说明结点个数不是k的整数倍，将最后不是整数倍的个元素的结点，
        // 再次使用尾插法进行还原
        if (count != 0) {
            curr = groupHead.next;
            groupHead.next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = groupHead.next;
                groupHead.next = curr;
                curr = next;
            }
        }

        return root.next;
    }
}
