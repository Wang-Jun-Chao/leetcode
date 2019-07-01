import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-01 14:16
 **/
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new LinkedList<>();

        if (num < 0 || num >= 9) {
            return result;
        }

        if (num == 0) {
            result.add("0:00");
            return result;
        }

        int[] values = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

        List<Integer> current = new ArrayList<>();
        readBinaryWatch(values, 0, num, num, current, result);

        return result;
    }

    private void readBinaryWatch(int[] values, int start, int left, int total, List<Integer> current, List<String> result) {

        if (left == 0) {
            if (total != current.size()) {
                return;
            }

            int hour = 0;
            int minute = 0;
            for (int i : current) {
                if (i < 4) {
                    hour += values[i];
                    if (hour > 11) {
                        return;
                    }
                } else {
                    minute += values[i];
                    if (minute > 59) {
                        return;
                    }
                }
            }

            result.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
            return;
        }

        for (int i = start; i < values.length - left + 1; i++) {
            current.add(i);
            readBinaryWatch(values, i + 1, left - 1, total, current, result);
            current.remove(current.size() - 1);
        }
    }
}
