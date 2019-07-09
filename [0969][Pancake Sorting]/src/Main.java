import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 18:37
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        Assert.assertEquals(Arrays.asList(4, 2, 4, 3), solution.pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
