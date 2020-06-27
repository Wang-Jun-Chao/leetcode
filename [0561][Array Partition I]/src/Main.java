import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-04 08:49
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] arr = {1, 4, 3, 2};
        Assert.assertEquals(4, solution.arrayPairSum(arr));
    }
}
