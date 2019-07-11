import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 11:26
 **/
public class Main {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);

        Solution solution = new Solution();

        Assert.assertArrayEquals(new int[]{2}, solution.findMode(root));
    }
}
