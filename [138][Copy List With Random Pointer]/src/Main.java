/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-24
 * Time: 09:18
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Solution solution = new Solution();
        RandomListNode copy = solution.copyRandomList(n1);

        print(copy);

    }

    public static  void print(RandomListNode head) {
        while (head != null) {
            System.out.print(head.label + "->");
            head = head.next;
        }

        System.out.println("null");
    }
}
