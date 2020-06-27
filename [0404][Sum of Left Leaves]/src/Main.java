import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-30 14:18
 **/
public class Main {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        Assert.assertEquals(24, solution.sumOfLeftLeaves(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);

        Solution solution = new Solution();
        Assert.assertEquals(0, solution.sumOfLeftLeaves(root));
    }
}
