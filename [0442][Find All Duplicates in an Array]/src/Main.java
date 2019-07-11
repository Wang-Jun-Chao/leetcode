import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 14:08
 **/
public class Main {
    @Test
    public void test1() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution solution = new Solution();
        Assert.assertEquals(Arrays.asList(2, 3), solution.findDuplicates(nums));
    }
}
