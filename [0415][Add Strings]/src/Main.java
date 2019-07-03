import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 04:35
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals("10000", solution.addStrings("9999", "1"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals("10098", solution.addStrings("9999", "99"));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals("9133", solution.addStrings("9133", "0"));
    }
}
