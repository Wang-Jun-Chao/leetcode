/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 10:01
 **/
public class Test {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        Solution solution = new Solution();
        solution.deleteNode(node.next);

        print(node);
    }

    private static void print(ListNode node) {
        do {
            if (node == null) {
                System.out.println("null");
            } else if (node.next != null) {
                System.out.print(node.val + "->");
                node = node.next;
            } else {
                System.out.println(node.val + "->null");
                node = node.next;
            }

        } while (node != null);
    }
}
