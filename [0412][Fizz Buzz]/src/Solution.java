import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 16:34
 **/
public class Solution {
    /**
     * <pre>
     * Write a program that outputs the string representation of numbers from 1 to n.
     *
     * But for multiples of three it should output “Fizz” instead of the number and for
     * the multiples of five output “Buzz”. For numbers which are multiples of both three
     * and five output “FizzBuzz”.
     *
     * Example:
     *
     * n = 15,
     *
     * Return:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     * </pre>
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add("" + i);
            }
        }

        return result;
    }
}
