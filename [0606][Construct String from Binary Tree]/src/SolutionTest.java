import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-04 20:12
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void tree2str() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        Solution s = new Solution();
        Assert.assertEquals("1(2(4))(3)", s.tree2str(root));
    }

    @org.junit.Test
    public void tree2str2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        Solution s = new Solution();
        Assert.assertEquals("1(2()(4))(3)", s.tree2str(root));
    }
}