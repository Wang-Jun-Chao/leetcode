import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-30 13:50
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.firstUniqChar("leetcode"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.firstUniqChar("loveleetcode"));
    }
}
