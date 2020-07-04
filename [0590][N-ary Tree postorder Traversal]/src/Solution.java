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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
//        postorderReserve(root, result);
        postorderIterator(root, result);
        return result;
    }

    public void postorderIterator(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        Node curr;
        Node prev = null;
        while (!deque.isEmpty()) {
            curr = deque.getFirst();
            if (curr.children == null || curr.children.isEmpty() // 没有子孩子
                    ||(prev != null && prev == curr.children.get(curr.children.size() - 1))) { // 前一个遍历的元素是最后一个子孩子，说明子树已经遍历完了
                result.add(curr.val);
                prev = curr;
                deque.removeFirst();
            } else {
                // 有孩子先处理孩子
                int size = curr.children.size();
                for (int i = size - 1; i >= 0; i--) {
                    Node child = curr.children.get(i);
                    if (child != null) {
                        deque.addFirst(child);
                    }
                }
            }
        }
    }

    public void postorderReserve(Node root, List<Integer> result) {

        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node n : root.children) {
                postorderReserve(n, result);
            }
        }

        result.add(root.val);
    }
}
