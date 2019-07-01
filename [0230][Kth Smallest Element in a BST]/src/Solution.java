import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {

        int count = 0;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.addLast(root);
        // 用于记录下一个需要开始遍历的结点
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            // 找最左节点
            while (node != null) {
                deque.addLast(node);
                node = node.left;
            }

            // 如果还有结点，就出栈
            if (!deque.isEmpty()) {
                node = deque.removeLast();
                count++;
                if (count == k) {
                    return node.val;
                }

                // 记录下一个待处理的节点
                node = node.right;
            }
        }

        throw new NoSuchElementException();
    }
}