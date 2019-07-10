import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 08:39
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        Assert.assertEquals(1, solution.findContentChildren(g, s));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        Assert.assertEquals(2, solution.findContentChildren(g, s));
    }
}
