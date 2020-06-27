import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 13:05
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals("", solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
