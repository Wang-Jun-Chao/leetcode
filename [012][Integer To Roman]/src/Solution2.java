/**
 * Author: 王俊超
 * Date: 2015-06-30
 * Time: 14:28
 * Declaration: All Rights Reserved !!!
 */
public class Solution2 {
    /**
     * <pre>
     * Given an integer, convert it to a roman numeral.
     *
     * Input is guaranteed to be within the range from 1 to 3999.
     *
     * 罗马数字的表示：
     * 个位数举例
     * (I, 1)  (II, 2)  (III, 3)  (IV, 4)  (V, 5)  (VI, 6)  (VII, 7)  (VIII, 8)  (IX, 9)
     *
     * 十位数举例
     * (X, 10)  (XI, 11)  (XII, 12)  (XIII, 13)  (XIV, 14)  (XV, 15)  (XVI, 16)
     * (XVII, 17)  (XVIII, 18)  (XIX, 19)  (XX, 20)  (XXI, 21)  (XXII, 22)
     * (XXIX, 29)  (XXX, 30)  (XXXIV, 34)  (XXXV, 35)  (XXXIX, 39)  (XL, 40)
     * (L, 50)  (LI, 51)  (LV, 55)  (LX, 60)  (LXV, 65)  (LXXX, 80)  (XC, 90)
     * (XCIII, 93)  (XCV, 95)  (XCVIII, 98)  (XCIX, 99)
     *
     * 百位数举例
     * (C, 100)  (CC, 200)  (CCC, 300)  (CD, 400)  (D, 500)  (DC, 600)  (DCC, 700)
     * (DCCC, 800)  (CM, 900)  (CMXCIX, 999)
     *
     * 千位数举例
     * (M, 1000)  (MC, 1100)  (MCD, 1400)  (MD, 1500)  (MDC, 1600)  (MDCLXVI, 1666)
     * (MDCCCLXXXVIII, 1888)  (MDCCCXCIX, 1899)  (MCM, 1900)  (MCMLXXVI, 1976)
     * (MCMLXXXIV, 1984)  (MCMXC, 1990)  (MM, 2000)  (MMMCMXCIX, 3999)
     *
     * 题目大意：
     * 输入一个数字，将它转成一个罗马数字，输入的数字在[1, 3999]之间
     *
     * </pre>
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        final int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String roman = "";
        for (int i = 0; num > 0; ++i) {
            int count = num / radix[i];
            num %= radix[i];
            for (; count > 0; --count) {
                roman += symbol[i];
            }
        }
        return roman;
    }
}
