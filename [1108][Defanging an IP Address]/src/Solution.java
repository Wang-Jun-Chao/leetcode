/**
 * https://leetcode.com/problems/defanging-an-ip-address/submissions/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-12 08:31
 **/
public class Solution {
    /**
     * <pre>
     * Given a valid (IPv4) IP address, return a defanged version of that IP address.
     *
     * A defanged IP address replaces every period "." with "[.]".
     *
     *
     *
     * Example 1:
     *
     * Input: address = "1.1.1.1"
     * Output: "1[.]1[.]1[.]1"
     * Example 2:
     *
     * Input: address = "255.100.50.0"
     * Output: "255[.]100[.]50[.]0"
     * </pre>
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        if (address == null || address.length() < 1) {
            return address;
        }

        StringBuilder builder = new StringBuilder(address.length() * 2);

        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (Character.isDigit(ch)) {
                builder.append(ch);
            } else if (ch == '.') {
                builder.append("[.]");
            } else {
                throw new IllegalArgumentException(address + " contains invalid char");
            }
        }


        return builder.toString();
    }
}
