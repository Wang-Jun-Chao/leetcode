import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-30 14:31
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, solution.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{0, 0}, solution.productExceptSelf(new int[]{0, 0}));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{1, 0}, solution.productExceptSelf(new int[]{0, 1}));
    }
}
