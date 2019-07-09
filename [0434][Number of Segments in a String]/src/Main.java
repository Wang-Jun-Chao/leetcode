import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 16:51
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        Assert.assertEquals(5, solution.countSegments("Hello, my name is John"));
    }
}
