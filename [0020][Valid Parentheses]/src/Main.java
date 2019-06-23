import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 14:46
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        Assert.assertEquals(true, solution.isValid("()"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();

        Assert.assertEquals(false, solution.isValid("(]"));
    }
}
