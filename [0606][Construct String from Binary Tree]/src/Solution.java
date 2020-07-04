/**
 * Author: 王俊超
 * Time: 2020-07-04 20:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder builder = new StringBuilder(100);
        tree2str(t, builder);
        return builder.toString();
    }

    private void tree2str(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }

        builder.append(root.val);

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null && root.right == null) {
            builder.append("(");
            tree2str(root.left, builder);
            builder.append(")");
        }

        if (root.right != null) {
            builder.append("(");
            tree2str(root.left, builder);
            builder.append(")");
            builder.append("(");
            tree2str(root.right, builder);
            builder.append(")");
        }
    }
}
