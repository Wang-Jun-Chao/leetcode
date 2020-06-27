/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 16:44
 **/
public class Solution {
    /**
     * <pre>
     * Count the number of segments in a string, where a segment is defined to be a
     * contiguous sequence of non-space characters.
     *
     * Please note that the string does not contain any non-printable characters.
     *
     * Example:
     *
     * Input: "Hello, my name is John"
     * Output: 5
     * </pre>
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int count = 0;
        if (s == null || s.length() < 1) {
            return count;
        }

        int start = 0;
        int end;
        while (start < s.length()) {
            while (start < s.length() && s.charAt(start) == ' ') {
                start++;
            }

            end = start + 1;
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }

            if (start < s.length()) {
                count++;
            }

            start = end + 1;
        }

        return count;
    }
}
