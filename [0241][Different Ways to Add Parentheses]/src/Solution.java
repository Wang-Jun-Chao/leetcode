import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-06 20:25
 **/
public class Solution {
    /**
     * <pre>
     * Given a string of numbers and operators, return all possible results from computing all the
     * different possible ways to group numbers and operators. The valid operators are +, - and *.
     *
     * Example 1:
     *
     * Input: "2-1-1"
     * Output: [0, 2]
     * Explanation:
     * ((2-1)-1) = 0
     * (2-(1-1)) = 2
     * Example 2:
     *
     * Input: "2*3-4*5"
     * Output: [-34, -14, -10, -10, 10]
     * Explanation:
     * (2*(3-(4*5))) = -34
     * ((2*3)-(4*5)) = -14
     * ((2*(3-4))*5) = -10
     * (2*((3-4)*5)) = -10
     * (((2*3)-4)*5) = 10
     * </pre>
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Character> operator = new ArrayList<>();
        List<Integer> operand = new ArrayList<>();

        int start = 0;
        int end;
        while (start < input.length()) {
            end = start + 1;
            while (end < input.length()
                    && input.charAt(end) >= '0'
                    && input.charAt(end) <= '9') {
                end++;
            }
            operand.add(Integer.parseInt(input.substring(start, end)));

            if (end < input.length()) {
                operator.add(input.charAt(end));
            }
            start = end + 1;
        }

        return diffWaysToCompute(operand, operator);
    }

    /**
     * @param operand
     * @param operator
     * @return
     */
    private List<Integer> diffWaysToCompute(List<Integer> operand, List<Character> operator) {

        List<Integer> result = new LinkedList<>();

        if (operator.isEmpty()) {
            result.addAll(operand);
            return result;
        }


        if (operator.size() == 1) {
            result.add(calculate(operand.get(0), operand.get(1), operator.get(0)));
            return result;
        }

        for (int i = 0; i < operator.size(); i++) {
            List<Integer> left = diffWaysToCompute(
                    new ArrayList<>(operand.subList(0, i + 1)),
                    new ArrayList<>(operator.subList(0, i)));
            List<Integer> right = diffWaysToCompute(
                    new ArrayList<>(operand.subList(i + 1, operand.size())),
                    new ArrayList<>(operator.subList(i + 1, operator.size())));

            for (int x : left) {
                for (int y : right) {
                    result.add(calculate(x, y, operator.get(i)));
                }
            }
        }

        return result;

    }

    private Integer calculate(Integer a, Integer b, Character op) {

        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new RuntimeException("no such " + a + op + b + " option exception");
        }
    }
}
