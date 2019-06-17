import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 14:03
 **/
public class Main {

    @Test
    public void test1() {
        Solution2 solution = new Solution2();
        Assert.assertEquals("III", solution.intToRoman(3));
    }

    @Test
    public void test2() {
        Solution2 solution = new Solution2();
        Assert.assertEquals("IV", solution.intToRoman(4));
    }

    @Test
    public void test3() {
        Solution2 solution = new Solution2();
        Assert.assertEquals("IX", solution.intToRoman(9));
    }

    @Test
    public void test4() {
        Solution2 solution = new Solution2();
        Assert.assertEquals("LVIII", solution.intToRoman(58));
    }

    @Test
    public void test5() {
        Solution2 solution = new Solution2();
        Assert.assertEquals("MCMXCIV", solution.intToRoman(1994));
    }
}
