import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 04:56
 **/
public class Main {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        Solution solution = new Solution();
        Assert.assertEquals(3, solution.pathSum(root, 8));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        Solution solution = new Solution();
        Assert.assertEquals(2, solution.pathSum(root.left, 8));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        Solution solution = new Solution();
        Assert.assertEquals(1, solution.pathSum(root.left.right, 3));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        Solution solution = new Solution();
        Assert.assertEquals(1, solution.pathSum(root.right, 8));
    }

    @Test
    public void test5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);

        Solution solution = new Solution();
        Assert.assertEquals(3, solution.pathSum(root, 1));

    }

    @Test
    public void test6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        Solution solution = new Solution();
        Assert.assertEquals(3, solution.pathSum(root, 1));

    }
}
