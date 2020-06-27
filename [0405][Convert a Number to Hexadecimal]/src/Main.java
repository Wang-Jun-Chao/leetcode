import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 03:59
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals("1a", solution.toHex(26));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals("ffffffff", solution.toHex(-1));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals("10", solution.toHex(16));
    }
}
