/**
 * O(n) time and O(n) space
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 11:02
 **/
public class Solution2 {
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        // 反向链的头
        ListNode reverseHead = new ListNode(-1);

        ListNode temp = head;
        ListNode node;
        // 头插法构建反向链
        while (temp != null) {
            node = new ListNode(temp.val);
            node.next = reverseHead.next;
            reverseHead.next = node;
            temp = temp.next;
        }

        reverseHead = reverseHead.next;
        while (head != null) {
            if (head.val != reverseHead.val) {
                return false;
            }

            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }
}
