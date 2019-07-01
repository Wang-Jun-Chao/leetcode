import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-07-25
 * Time: 18:19
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        // 用于记录当前需要处理的元素
        TreeNode node = root;

        // node的两种情况：1、root结点，2、父结点的右孩子
        while (node != null || !stack.isEmpty()) {
            // 将自身及左孩子入栈
            while (node != null) {
                stack.addLast(node);
                node = node.left;
            }

            // 此时栈中的栈顶元素一定是没有左孩子的
            if (!stack.isEmpty()) {
                // 删除栈顶元素
                node = stack.removeLast();
                result.add(node.val);
                // 指右孩子
                node = node.right;
            }
        }
        return result;
    }
}
