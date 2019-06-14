/**
 * Author: 王俊超
 * Date: 2015-06-19
 * Time: 13:57
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Remove all elements from a linked list of integers that have value val.
     * <p>
     * Example
     * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     * Return: 1 --> 2 --> 3 --> 4 --> 5
     * <p>
     * 给定一值val，在单链表中删除值为val的结点
     * <p>
     * 解题思路
     * 在链表头添加一个结点，对链表进遍历和删除操作
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(1);
        root.next = head;
        // 调于记录要处理的元素的前驱结点
        ListNode prev = root;

        // prev.next表示要处理的结点
        while (prev.next != null) {
            // 要处理的结点是要删除的结点
            if (prev.next.val == val) {
                // 对结点进行删除操作
                prev.next = prev.next.next;
            }
            // 当前处理的节点不需要删除，prev移动到下一个结点
            else {
                prev = prev.next;
            }
        }

        // 返回新的根结点
        return root.next;
    }
}
