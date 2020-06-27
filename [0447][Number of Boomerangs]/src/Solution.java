import java.util.HashMap;
import java.util.Map;

/**
 * Author: 王俊超
 * Time: 2020-06-26 16:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        if (points == null || points.length < 2) {
            return count;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {

                if (i == j) {
                    continue;
                }
                int square = square(points[i], points[j]);
                if (!map.containsKey(square)) {
                    map.put(square, 1);
                } else {
                    count += map.get(square) * 2; // A
                    int oldCount = map.get(square);
                    map.put(square, oldCount + 1);
                }
            }

            // 如果不在A处理，那么对于大于1的value，取组合值
            // C(2, n) * 2 = 1*2*...*(n-2)*2
            // 放在A处理进行了分散处理

            map.clear();
        }

        return count;

    }

    public int numberOfBoomerangsSlow(int[][] points) {

        int answer = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j && square(points[k], points[i]) == square(points[k], points[j])) {
                        answer += 2;
                    }
                }
            }
        }

        return answer;
    }

    public int square(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];

        return x * x + y * y;
    }

}
