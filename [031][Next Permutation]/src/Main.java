import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-14 21:30
 **/
public class Main {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
