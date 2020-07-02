import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Author: 王俊超
 * Time: 2020-07-02 08:38
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void findTilt() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Assert.assertEquals(1, s.findTilt(root));
    }
}