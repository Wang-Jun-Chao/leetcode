import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 19:20
 **/
public class Main {
    @Test
    public void test1() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.findMaxConsecutiveOnes(nums));
    }

    @Test
    public void test2() {
        int[] nums = {0};
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findMaxConsecutiveOnes(nums));
    }
}
