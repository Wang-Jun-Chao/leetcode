import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 21:10
 **/
public class Main {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        Solution solution = new Solution();
        Assert.assertEquals(2, solution.distributeCoins(root));
    }
}
