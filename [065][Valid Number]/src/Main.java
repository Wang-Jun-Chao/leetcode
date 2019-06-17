import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 13:32
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.isNumber("0"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.isNumber(" 0.1 "));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber("abc"));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber("1 a"));
    }

    @Test
    public void test41() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.isNumber("2e10"));
    }

    @Test
    public void test42() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.isNumber(" -90e3   "));
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber(" 1e"));
    }

    @Test
    public void test6() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber("e3"));
    }


    @Test
    public void test7() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.isNumber(" 6e-1"));
    }

    @Test
    public void test8() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber(" 99e2.5 "));
    }


    @Test
    public void test9() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.isNumber("53.5e93"));
    }

    @Test
    public void test10() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber(" --6 "));
    }

    @Test
    public void test11() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber("-+3"));
    }

    @Test
    public void test12() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isNumber("95a54e53"));
    }

}
