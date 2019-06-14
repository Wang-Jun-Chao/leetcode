import java.util.LinkedList;
import java.util.List;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-23
 * Time: 08:08
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        TreeNode root = solution.sortedListToBST(n1);
        print2(root);
    }

    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + ", ");
            print(root.right);
        }
    }

    public static void print2(TreeNode root) {
        if (root != null) {
            List<TreeNode> list = new LinkedList<>();
            list.add(root);
            TreeNode node;
            int curr = 1;
            int next = 0;
            while (!list.isEmpty()) {
                node = list.remove(0);
                curr--;
                System.out.print(node.val + ", ");

                if (node.left != null) {
                    list.add(node.left);
                    next++;
                }

                if (node.right != null) {
                    list.add(node.right);
                    next++;
                }

                if (curr == 0) {
                    System.out.println();
                    curr = next;
                    next = 0;
                }
            }
        }
    }
}
