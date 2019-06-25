import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-25 19:22
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        Assert.assertEquals(3, solution.numDecodings("226"));
    }
}
