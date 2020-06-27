/**
 * O(n) time and O(1) space
 * <pre>
 * 1->2->2->1
 * 1->2->3->2->1
 * 先找到第二个2的位置，将2及后面的链逆转，形成新的链A，再按A与原来的链，从头开开始比较
 * </pre>
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 11:02
 **/
public class Solution {
    public boolean isPalindrome(ListNode head) {

        // 没有节点或者只有一个结点
        if (head == null || head.next == null) {
            return true;
        }

        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        // 找反向链的起始位置
        count = (count + 1) / 2;
        node = head;
        while (count > 0) {
            count--;
            node = node.next;
        }


        ListNode reverseHead = new ListNode(0);
        ListNode temp;
        while (node != null) {
            temp = node.next;
            node.next = reverseHead.next;
            reverseHead.next = node;
            node = temp;
        }

        reverseHead = reverseHead.next;

        while (reverseHead != null) {
            if (head.val != reverseHead.val) {
                return false;
            }

            reverseHead = reverseHead.next;
            head = head.next;
        }

        return true;
    }
}
