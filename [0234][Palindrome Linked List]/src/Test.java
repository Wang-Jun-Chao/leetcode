/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 11:10
 **/
public class Test {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(solution.isPalindrome(head));
    }

    public static void test2() {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(head));
    }

    public static void test3() {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(solution.isPalindrome(head));
    }
}
