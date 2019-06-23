import java.util.LinkedList;
import java.util.List;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-22
 * Time: 19:49
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n7;

        Solution solution = new Solution();
        solution.connect(n1);
//        print(n1);


    }

    public static void print(TreeLinkNode root) {
        if (root != null) {
            TreeLinkNode curr;
            List<TreeLinkNode> list = new LinkedList<>();
            list.add(root);

            while (list.size() > 0) {
                curr = list.get(0);
            }
        }
    }
}
