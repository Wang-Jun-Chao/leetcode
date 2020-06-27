/**
 * <pre>
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * </pre>
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 09:57
 **/
class Solution {
    public void deleteNode(ListNode node) {

        if (node == null || node.next == null) {
            return;
        }

        ListNode prev = node;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;


        }

        prev.next = null;
    }
}