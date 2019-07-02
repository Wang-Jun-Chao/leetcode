import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 04:15
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.longestPalindrome("abccccdd"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.longestPalindrome("aAaaaaaa"));
    }
}
