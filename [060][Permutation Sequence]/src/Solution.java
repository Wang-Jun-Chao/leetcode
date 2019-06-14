import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:45
 **/
public class Solution {
    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        List<Integer> num = new ArrayList<>();
        // 用于计录最大的阶乘数
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }

        // l = k - 1;为了方便从0开始计数
        int index;
        for (int i = 0, l = k - 1; i < n; i++) {
            // 从最大的阶乘数开始减少
            fact /= (n - i);
            // 计算剩下的数据中的索引
            index = (l / fact);
            // 将索引值添加到结果中
            sb.append(num.remove(index));
            // 余下要处理的数
            l -= index * fact;
        }
        return sb.toString();
    }
}
