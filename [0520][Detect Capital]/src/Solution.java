/**
 * Author: 王俊超
 * Time: 2020-06-29 08:42
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * <pre>
     * Given a word, you need to judge whether the usage of capitals in it is right or not.
     *
     * We define the usage of capitals in a word to be right when one of the following
     * cases holds:
     *
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital, like "Google".
     * Otherwise, we define that this word doesn't use capitals in a right way.
     *
     *
     * Example 1:
     *
     * Input: "USA"
     * Output: True
     *
     *
     * Example 2:
     *
     * Input: "FlaG"
     * Output: False
     *
     *
     * Note: The input will be a non-empty word consisting of uppercase
     * and lowercase latin letters.
     * </pre>
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {

        if (Character.isUpperCase(word.charAt(0))) {
            return isAllUpperCase(word.substring(1)) || isAllLowerCase(word.substring(1));
        } else if (Character.isLowerCase(word.charAt(0))) {
            return isAllLowerCase(word.substring(1));
        }

        return false;
    }

    private boolean isAllLowerCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLowerCase(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isAllUpperCase(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isUpperCase(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

