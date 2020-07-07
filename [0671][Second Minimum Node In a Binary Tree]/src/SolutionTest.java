import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-07 09:13
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findSecondMinimumValue() {
        Solution s = new Solution();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(5, s.findSecondMinimumValue(root));
    }
}