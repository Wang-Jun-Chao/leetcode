import java.util.HashSet;
import java.util.Set;

/**
 * Author: 王俊超
 * Time: 2020-07-05 18:20
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     *
     * @param root
     * @param k
     * @return
     */


    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetHelp(root, k, set);
    }

    private boolean findTargetHelp(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return findTargetHelp(root.left, k, set) || findTargetHelp(root.right, k, set);
    }

    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        visitTree(root, set);

        for (Integer n : set) {
            if (n != k - n && set.contains(k - n)) {
                return true;
            }
        }

        return false;
    }

    public void visitTree(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }

        set.add(root.val);

        visitTree(root.left, set);
        visitTree(root.right, set);
    }
}
