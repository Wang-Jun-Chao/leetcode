import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 19:08
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
