import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-12 08:37
 **/
public class Main {
    @Test
    public void test1() {
        String address = "1.1.1.1";
        Solution solution = new Solution();
        Assert.assertEquals("1[.]1[.]1[.]1", solution.defangIPaddr(address));
    }

    @Test
    public void test2() {
        String address = "255.100.50.0";
        Solution solution = new Solution();
        Assert.assertEquals("255[.]100[.]50[.]0", solution.defangIPaddr(address));
    }
}
