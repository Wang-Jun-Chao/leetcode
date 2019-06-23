import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-14 15:02
 **/
public class Main {
    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};

        Solution solution = new Solution();

        Assert.assertEquals(4, solution.longestConsecutive(nums));
    }
}
