/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-30
 * Time: 21:40
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        test01(1);
        test01(2);
        test01(3);
        test01(4);
        test01(5);
        test01(6);
    }

    private static void test01(int k) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution solution = new Solution();
        ListNode head = solution.reverseKGroup(n1, k);

        print(head);
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("null");
    }
}
