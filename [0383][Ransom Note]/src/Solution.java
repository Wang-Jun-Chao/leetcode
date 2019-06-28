/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 15:58
 **/
public class Solution {
    /**
     * <pre>
     * Given an arbitrary ransom note string and another string containing letters
     * from all the magazines, write a function that will return true if the ransom
     * note can be constructed from the magazines ; otherwise, it will return false.
     *
     * Each letter in the magazine string can only be used once in your ransom note.
     *
     * Note:
     * You may assume that both strings contain only lowercase letters.
     *
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     * </pre>
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 假设输入都是合法的

        int[] chars = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            chars[ransomNote.charAt(i) - 'a']--;
        }

        for (int n : chars) {
            if (n < 0) {
                return false;
            }
        }

        return true;
    }
}
