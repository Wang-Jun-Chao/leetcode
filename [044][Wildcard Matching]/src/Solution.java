/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:25
 **/
public class Solution {
    public boolean isMatch(String str, String pattern) {
        // 匹配串的索引
        int s = 0;
        // 模式串的索引
        int p = 0;
        // 记录匹配的匹配位置
        int match = 0;
        // 星号的起始索引
        int starIdx = -1;
        while (s < str.length()) {
            // 两个指针都往前推进
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // 发现一个*，只前进模式串索引
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                // 记录最后一次发现*的位置
                starIdx = p;
                // 记录在匹配串中匹配*时的位置
                match = s;
                // 模式串索引向前推进
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            // 最后的模式串索引是*，匹配串索引向前推进。这个条件隐含p >= pattern.length()，再加上starIdx != -1
            // 说明存在*号匹配，在星号匹配的
            else if (starIdx != -1) {
                // 记录模式串最后处理的*号的下一个位置
                p = starIdx + 1;
                // 记录在匹配串中匹配*时的位置
                match++;
                // 匹配串索引向前推进
                s = match;
            }
            // 当前的模式索引指向的不是*号，最后一个模式索引指向的也不是*号，说明不匹配
            else {
                return false;
            }
        }

        // 检查余下的模式串，模式串必须全都是*号才行
        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }

        return p == pattern.length();
    }
}
