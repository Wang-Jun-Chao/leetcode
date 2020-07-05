import org.junit.Assert;

/**
 * Author: 王俊超
 * Time: 2020-07-05 18:35
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findTarget() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);

        Assert.assertFalse(s.findTarget(root, 2));
    }
}