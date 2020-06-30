import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-06-29 11:33
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void getMinimumDifference() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        Solution s = new Solution();
        Assert.assertEquals(s.getMinimumDifference(root), 1);
    }

//    [236,104,701,null,227,null,911]

    @org.junit.Test
    public void getMinimumDifference2() {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.left.right = new TreeNode(227);
        root.right = new TreeNode(701);
        root.right.right = new TreeNode(911);

        Solution s = new Solution();
        Assert.assertEquals(s.getMinimumDifference(root), 9);
    }
}