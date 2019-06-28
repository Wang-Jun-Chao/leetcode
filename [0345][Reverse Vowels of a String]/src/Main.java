import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-27 20:03
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals("holle", solution.reverseVowels("hello"));
    }
}
