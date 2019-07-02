import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-02 08:18
 **/
public class Main {
    @Test
    public void test1() {
        int[] arr = {3, 2, 1};
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.thirdMax(arr));
    }

    @Test
    public void test2() {
        int[] arr = {2, 1};
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.thirdMax(arr));
    }

    @Test
    public void test3() {
        int[] arr = {2, 3, 2, 1};
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.thirdMax(arr));
    }

    @Test
    public void test4() {
        int[] arr = {1, 2, 2, 5, 3, 5};
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.thirdMax(arr));
    }
}
