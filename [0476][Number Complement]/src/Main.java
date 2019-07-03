import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 16:17
 **/
public class Main {

    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findComplement(5));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findComplement(0));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findComplement(1));
    }
}
