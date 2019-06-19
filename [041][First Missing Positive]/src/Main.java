import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-19 14:38
 **/
public class Main {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] arr = {1, 4, 3, 3, 2};
        int result = solution.firstMissingPositive(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(5, result);
    }
}
