/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 13:20
 **/
public class Solution {

    /**
     * 序数就分别为0, 1, 2, 3, 4, 5, 6
     */
    private enum InputType {
        INVALID,
        SPACE,
        SIGN,
        DIGIT,
        DOT,
        EXPONENT
    }

    // 状态转表 TODO 每个状态是什么意思？
    private final static int[][] TRANSITION_TABLE = {
            {-1, 0, 3, 1, 2, -1},  // next states for state 0
            {-1, 8, -1, 1, 4, 5}, // next states for state 1
            {-1, -1, -1, 4, -1, -1},// next states for state 2
            {-1, -1, -1, 1, 2, -1,},// next states for state 3
            {-1, 8, -1, 4, -1, 5},// next states for state 4
            {-1, -1, 6, 7, -1, -1},// next states for state 5
            {-1, -1, -1, 7, -1, -1},// next states for state 6
            {-1, 8, -1, 7, -1, -1},// next states for state 7
            {-1, 8, -1, -1, -1, -1},// next states for state 8
    };

    /**
     * <pre>
     * Validate if a given string can be interpreted as a decimal number.
     *
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     *
     * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements
     * up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
     *
     * Numbers 0-9
     * Exponent - "e"
     * Positive/negative sign - "+"/"-"
     * Decimal point - "."
     * Of course, the context of these characters also matters in the input.
     * </pre>
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            InputType inputType = InputType.INVALID;
            if (Character.isSpaceChar(s.charAt(i))) {
                inputType = InputType.SPACE;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                inputType = InputType.SIGN;
            } else if (Character.isDigit(s.charAt(i))) {
                inputType = InputType.DIGIT;
            } else if (s.charAt(i) == '.') {
                inputType = InputType.DOT;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                inputType = InputType.EXPONENT;
            }
            // Get next state from current state and input symbol
            state = TRANSITION_TABLE[state][inputType.ordinal()];

            // Invalid input
            if (state == -1) {
                return false;
            }
        }
        // If the current state belongs to one of the accepting (final) states,
        // then the number is valid
        return state == 1 || state == 4 || state == 7 || state == 8;
    }

    private boolean isDigit(char charAt) {
        return charAt >= '0' && charAt <= '9';
    }

    private boolean isSpace(char charAt) {
        return charAt == ' ';
    }
}
