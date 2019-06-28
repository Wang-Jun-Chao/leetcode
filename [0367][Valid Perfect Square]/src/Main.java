import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 15:18
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.isPerfectSquare(16));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isPerfectSquare(14));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isPerfectSquare(5));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isPerfectSquare(2147483647));
    }
}
