import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-16 11:16
 **/
public class MaxSubArray {
    public int[] solve(int[] array) {
        if (array == null || array.length < 1) {
            return null;
        }


        // result[0] 最大的子数组和
        // result[1] 最大的子数组的起始位置
        // result[2] 最大的子数组的结束位置
        int[] result = {Integer.MIN_VALUE, -1, -1};

        int sum = 0;
        int begin = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum >= 0) {
                sum += array[i];
            } else {
                sum = array[i];
                begin = i;
            }

            if (result[0] <= sum) {
                result[0] = sum;
                result[1] = begin;
                result[2] = i;
            }
        }

        return result;
    }

    @Test
    public void test1() {
        MaxSubArray maxSubArray = new MaxSubArray();

        System.out.println(Arrays.toString(maxSubArray.solve(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
