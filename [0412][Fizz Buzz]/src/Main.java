import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 16:37
 **/
public class Main {
    @Test
    public void test1() {
        String[] array = {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"};

        Solution solution = new Solution();

        Assert.assertEquals(Arrays.asList(array), solution.fizzBuzz(15));

    }
}
