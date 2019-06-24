import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 09:13
 **/
public class Main {

    @Test
    public void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.maxProfit(prices));
    }

    @Test
    public void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.maxProfit(prices));
    }

    @Test
    public void test3() {
        int[] prices = {7, 6, 4, 3, 1};
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    public void test4() {
        int[] prices = {3, 2, 9, 1, 7, 4};
        Solution2 solution = new Solution2();
        Assert.assertEquals(13, solution.maxProfit(prices));
    }
}
