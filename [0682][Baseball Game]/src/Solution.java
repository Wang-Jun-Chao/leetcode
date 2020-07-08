import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Time: 2020-07-07 12:46
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int calPoints(String[] ops) {

        if (ops == null || ops.length < 1) {
            return 0;
        }
        List<Integer> round = new LinkedList<>();

        for (String o : ops) {
            int size = round.size();
            switch (o) {
                case "+":
                    round.add(round.get(size - 1) + round.get(size - 2));
                    break;
                case "D":
                    round.add(2 * round.get(size - 1));
                    break;
                case "C":
                    round.remove(size - 1);
                    break;
                default:
                    round.add(Integer.parseInt(o));
            }
        }

        int sum = 0;
        for(Integer n : round) {
            sum += n;
        }

        return sum;
    }
}
