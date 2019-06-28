import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 16:44
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
