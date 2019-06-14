import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:45
 **/
public class Solution {
    /**
     * <pre>
     * 利用康托编码的思路，假设有n 个不重复的元素，第k 个排列是a1; a2; a3; :::; an，那么a1 是
     * 哪一个位置呢？
     * 我们把a1 去掉，那么剩下的排列为a2; a3; :::; an, 共计n-1 个元素，n-1 个元素共有(n-1)!
     * 个排列，于是就可以知道a1 = k/(n - 1)!。
     * 同理，a2; a3; :::; an 的值推导如下：
     * k2 = k%(n - 1)!
     * a2 = k2/(n - 2)!
     * ...
     * k(n-1) = k(n-2)%2!
     * a(n-1) = k(n-1)/1!
     * an = 0
     * </pre>
     *
     * @param n
     * @param k
     * @return
     */
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
            // fact的值说明，如果从 __1____ -> _2____ 至少要经过fact次变换
            fact /= (n - i);
            // 计算剩下的数据中的索引
            // 说明类似 __1____ -> _2____ 的变化可以做 index 次，0表示不用变
            index = (l / fact);
            // 将索引值添加到结果中
            // 每做一次__1____ -> _2____ 的变化，表示在num中取后一个更大的值
            sb.append(num.remove(index));
            // 余下要处理的数
            l -= index * fact;
        }

        return sb.toString();
    }
}
