/**
 * Author: 王俊超
 * Time: 2020-07-06 08:58
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val == L) {
            root.left = null;
            root.right = trimBST(root.right, L, R);
            return root;
        } else if (root.val == R) {
            root.left = trimBST(root.left, L, R);
            root.right = null;
            return root;
        } else if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
