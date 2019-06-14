import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-08-19
 * Time: 06:44
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.add(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.removeLast();
                result.add(node.val);

                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }

        return result;
    }
}
