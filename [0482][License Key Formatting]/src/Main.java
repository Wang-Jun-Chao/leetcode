import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 09:49
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals("5F3Z-2E9W", solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals("2-5G-3J", solution.licenseKeyFormatting("2-5g-3-J", 2));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals("2-5-G-3-J", solution.licenseKeyFormatting("2-5g-3-J", 1));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        Assert.assertEquals("25G3J", solution.licenseKeyFormatting("2-5g-3-J", 10));
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        Assert.assertEquals("", solution.licenseKeyFormatting("---", 3));
    }
}
