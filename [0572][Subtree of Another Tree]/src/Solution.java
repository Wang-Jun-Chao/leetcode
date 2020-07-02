import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: 王俊超
 * Time: 2020-07-02 09:02
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == t || t == null) {
            return true;
        }

        if (s == null) {
            return false;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(s);
        while (!queue.isEmpty()) {
            TreeNode root = queue.removeFirst();
            if (root.right != null) {
                queue.addFirst(root.right);
            }
            if (root.left != null) {
                queue.addFirst(root.left);
            }

            if(isSame(root, t)) {
                return true;
            }

        }

        return false;
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == t) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        boolean leftSame = isSame(s.left, t.left);
        boolean rightSame = isSame(s.right, t.right);

        return s.val == t.val && leftSame && rightSame;
    }
}
