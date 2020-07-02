import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Author: 王俊超
 * Time: 2020-07-02 09:11
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void isSubtree() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        Assert.assertEquals(true, s.isSubtree(root, t));
    }

    @org.junit.Test
    public void isSubtree2() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        Assert.assertEquals(false, s.isSubtree(root, t));
    }
}