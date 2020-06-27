//Given a string s and a string t, check if s is subsequence of t.
//
// A subsequence of a string is a new string which is formed from the original s
//tring by deleting some (can be none) of the characters without disturbing the re
//lative positions of the remaining characters. (ie, "ace" is a subsequence of "ab
//cde" while "aec" is not).
//
// Follow up:
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you w
//ant to check one by one to see if T has its subsequence. In this scenario, how w
//ould you change your code?
//
// Credits:
//Special thanks to @pbrother for adding this problem and creating all test case
//s.
//
//
// Example 1:
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2:
// Input: s = "axc", t = "ahbgdc"
//Output: false
//
//
// Constraints:
//
//
// 0 <= s.length <= 100
// 0 <= t.length <= 10^4
// Both strings consists only of lowercase characters.
//
// Related Topics Binary Search Dynamic Programming Greedy


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Author: 王俊超
 * Time: 2020-06-24 10:48
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        if (t.length() == 0) {
            return false;
        }

        int idxT = 0;
        int idxS = 0;
        while (idxS < s.length() && idxT < t.length()) {

            if (s.charAt(idxS) == t.charAt(idxT)) {
                idxS++;
                idxT++;
            } else {
                idxT++;
            }
        }


        return idxS == s.length();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
