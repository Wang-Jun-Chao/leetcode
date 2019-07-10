import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 13:47
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] arr = {0, 1, 2, 4, 5, 7};
        Assert.assertEquals(Arrays.asList("0->2", "4->5", "7"), solution.summaryRanges(arr));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] arr = {0, 2, 3, 4, 6, 8, 9};
        Assert.assertEquals(Arrays.asList("0", "2->4", "6", "8->9"), solution.summaryRanges(arr));
    }
}
