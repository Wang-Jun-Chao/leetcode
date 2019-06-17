import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-16 11:06
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int pos = solution.canCompleteCircuit(gas, cost);
        Assert.assertEquals(3, pos);
    }
}
