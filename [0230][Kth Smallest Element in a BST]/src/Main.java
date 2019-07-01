import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-01 17:42
 **/
public class Main {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.kthSmallest(root, 1));
        Assert.assertEquals(2, solution.kthSmallest(root, 2));
        Assert.assertEquals(3, solution.kthSmallest(root, 3));
        Assert.assertEquals(4, solution.kthSmallest(root, 4));
    }
}
