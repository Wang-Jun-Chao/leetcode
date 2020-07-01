import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Author: 王俊超
 * Time: 2020-07-01 08:57
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class SolutionTest {

    @org.junit.Test
    public void diameterOfBinaryTree() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Assert.assertEquals(3, s.diameterOfBinaryTree(root));
    }
}