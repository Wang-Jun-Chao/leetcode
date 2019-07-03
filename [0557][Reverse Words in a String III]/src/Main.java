import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 17:51
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc",
                solution.reverseWords("Let's take LeetCode contest"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();

        Assert.assertEquals("  cba",
                solution.reverseWords("  abc"));
    }
}
