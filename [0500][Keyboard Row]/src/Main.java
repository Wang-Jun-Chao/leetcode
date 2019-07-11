import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 10:39
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();

        Assert.assertArrayEquals(new String[]{"Alaska", "Dad"}, solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }
}
