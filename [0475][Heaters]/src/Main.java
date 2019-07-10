import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 09:30
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        Assert.assertEquals(1, solution.findRadius(houses, heaters));
    }
}
