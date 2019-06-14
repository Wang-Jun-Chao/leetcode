import java.util.LinkedList;
import java.util.List;

/**
 * Author: Íõ¿¡³¬
 * Date: 2015-06-23
 * Time: 09:24
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] t = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        List<List<Integer>> tri = new LinkedList<>();
        for (int i = 0; i < t.length; i++) {
            List<Integer> line = new LinkedList<>();
            for (int j = 0; j < t[i].length; j++) {
                line.add(t[i][j]);
            }

            tri.add(line);
        }

        System.out.println(tri);
        System.out.println(solution.minimumTotal(tri));
    }
}
