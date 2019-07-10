import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-10 13:23
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.calculate("3+2*2"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.calculate(" 3 + 5 / 2 "));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.calculate("1-1+1"));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.calculate("1+1-1"));
    }
}
