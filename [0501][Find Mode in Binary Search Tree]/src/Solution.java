import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-11 11:08
 **/
public class Solution {
    public int[] findMode(TreeNode root) {
        SortedMap<Integer, Integer> map = new TreeMap<>();

        findMode(root, map);

        int max = 0;
        for (int v : map.values()) {
            if (max < v) {
                max = v;
            }
        }

        List<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                list.add(e.getKey());
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (int v : list) {
            result[i] = v;
            i++;
        }
        return result;
    }

    private void findMode(TreeNode root, SortedMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        Integer count = map.get(root.val);
        map.put(root.val, count == null ? 1 : count + 1);
        findMode(root.left, map);
        findMode(root.right, map);

    }
}
