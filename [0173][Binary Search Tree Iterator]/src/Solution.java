import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 17:06
 **/
public class Solution {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        Assert.assertEquals(3, iterator.next()); // return 3
        Assert.assertEquals(7, iterator.next()); // return 7
        Assert.assertEquals(true, iterator.hasNext()); // return true
        Assert.assertEquals(9, iterator.next()); // return 9
        Assert.assertEquals(true, iterator.hasNext()); // return true
        Assert.assertEquals(15, iterator.next()); // return 15
        Assert.assertEquals(true, iterator.hasNext()); // return true
        Assert.assertEquals(20, iterator.next()); // return 20
        Assert.assertEquals(false, iterator.hasNext()); // return false
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(7);
        BSTIterator iterator = new BSTIterator(root);
        Assert.assertEquals(7, iterator.next()); // return 3
        Assert.assertEquals(false, iterator.hasNext()); // return false
        Assert.assertEquals(false, iterator.hasNext()); // return false
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        BSTIterator iterator = new BSTIterator(root);
        Assert.assertEquals(true, iterator.hasNext()); // return 3
        Assert.assertEquals(1, iterator.next()); // return 3
        Assert.assertEquals(true, iterator.hasNext()); // return false
        Assert.assertEquals(2, iterator.next()); // return false
        Assert.assertEquals(false, iterator.hasNext()); // return false
    }
}
