import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 16:00
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.canConstruct("a", "b"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.canConstruct("aa", "ab"));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.canConstruct("aa", "aab"));
    }


}
