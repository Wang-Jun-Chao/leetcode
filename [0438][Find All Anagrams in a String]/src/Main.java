import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-08 20:07
 **/
public class Main {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(Arrays.asList(0, 6), solution.findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(Arrays.asList(0, 1, 2), solution.findAnagrams("abab", "ab"));
    }
}
