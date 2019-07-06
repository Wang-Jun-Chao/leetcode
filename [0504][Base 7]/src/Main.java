import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 20:00
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals("202", solution.convertToBase7(100));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals("-10", solution.convertToBase7(-7));
    }
}
