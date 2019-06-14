import java.util.LinkedList;
import java.util.List;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-07-25
 * Time: 18:19
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.addLast(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.removeLast();
                result.add(node.val);
                node = node.right;
            }
        }

        System.out.println(result);
        return result;
    }
}
