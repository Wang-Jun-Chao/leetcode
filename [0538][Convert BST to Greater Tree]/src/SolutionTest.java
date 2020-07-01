import static org.junit.Assert.*;

/**
 * Author: 王俊超
 * Time: 2020-06-30 10:14
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void convertBST() {
        Solution s = new Solution();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right =new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        s.convertBST(root);

        print(root);
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }

        print(root.left);
        System.out.println(root.val);
        print(root.right);

    }
}