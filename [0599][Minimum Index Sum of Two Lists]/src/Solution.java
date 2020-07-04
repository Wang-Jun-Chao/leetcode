import java.util.*;

/**
 * Author: 王俊超
 * Time: 2020-07-04 16:13
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null){
            return null;
        }

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>(list1.length);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < min) {
                    result.clear();
                    min = map.get(list2[i]) + i;
                    result.add(list2[i]);
                } else if (map.get(list2[i]) + i == min) {
                    result.add(list2[i]);
                }

            }
        }

        return result.toArray(new String[0]);
    }
}
