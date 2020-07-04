import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Time: 2020-07-03 10:20
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
//        preorderReserve(root, result);
        preorderIterator(root, result);
        return result;
    }

    public void preorderIterator(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            Node n = deque.removeFirst();
            result.add(n.val);
            if (n.children != null) {
                int size = n.children.size();
                for (int i = size - 1; i >= 0; i--) {
                    Node child = n.children.get(i);
                    if (child != null) {
                        deque.addFirst(child);
                    }
                }
            }
        }
    }

    public void preorderReserve(Node root, List<Integer> result) {

        if (root == null) {
            return;
        }

        result.add(root.val);
        if (root.children != null) {
            for (Node n : root.children) {
                preorderReserve(n, result);
            }
        }
    }
}
