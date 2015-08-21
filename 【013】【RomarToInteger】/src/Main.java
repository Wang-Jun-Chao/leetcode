/**
 * Author: 王俊超
 * Date: 2015-03-01
 * Time: 16:35
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.romanToInt("I"));
        System.out.println(solution.romanToInt("II"));
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("V"));
        System.out.println(solution.romanToInt("VI"));

        System.out.println(solution.romanToInt("XCVIII"));
        System.out.println(solution.romanToInt("XCIX"));

        System.out.println(solution.romanToInt("CM"));
        System.out.println(solution.romanToInt("CMXCIX"));

        System.out.println(solution.romanToInt("MDCLXVI"));
        System.out.println(solution.romanToInt("MCMLXXVI"));
        System.out.println(solution.romanToInt("MMMCMXCIX"));
    }
}
