import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: 王俊超
 * Time: 2020-06-30 10:06
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 解题思路
     * root提个二叉搜索树
     * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     * 先处理右子树，再处理自己，再处理左子树
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {

        if (root == null) {
            return null;
        }
        Deque<TreeNode> s = new LinkedList<>();
        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);//先访问再入栈
                curr = curr.right;
            }
            curr = s.pop();

            if (prev == null) {
                prev = curr;
            } else {
                curr.val += prev.val;
            }

            prev = curr;
            curr = curr.left;//如果是null，出栈并处理左子树
        }

        return root;
    }
}
