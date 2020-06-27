import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:33
 **/
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagrams2(strs);
    }

    /**
     * 算法原理：对字符串进行排序，相同类型的字符串排序后的字符串都是一样的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<>();
        // 处理每一个字符串
        for (String s : strs) {
            char[] ca = s.toCharArray();
            // 对象字符串对应的字符数组进行排序，再转成排序后的字符串
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            // 如果map中不包含已经排序后的字符串，那么就创建一个新容器要放入结果
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }

            // 结果放入对应的集合中
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    /**
     * 算法原理：统计每个字符出现的次数，然后使用#字符将每个字符出现的次数拼成一个字符串，
     * 相同类型的字符串通过上面的方式拼出来的字符串都是一样的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];

        for (String s : strs) {
            // 清零操作
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // 字符串拼接
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
