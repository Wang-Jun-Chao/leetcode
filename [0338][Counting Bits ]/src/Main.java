import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 20:50
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{0, 1, 1}, solution.countBits(2));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, solution.countBits(5));
    }
}
