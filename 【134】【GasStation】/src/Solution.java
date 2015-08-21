/**
 * Author: 王俊超
 * Date: 2015-06-21
 * Time: 10:11
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * There are N gas stations along a circular route, where the amount
     * of gas at station i is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas
     * to travel from station i to its next station (i+1). You begin the journey
     * with an empty tank at one of the gas stations.
     *
     * Return the starting gas station's index if you can travel around the
     * circuit once, otherwise return -1.
     *
     * Note:
     *   - The solution is guaranteed to be unique.
     *
     * 题目大意：
     * 沿环形路线有N个加油站，其中气体在车站i是量是gas[i]。
     * 你有车有无限容量的气罐，从加油站i到下一个加油站站点i+1，要消耗cost[i]的气体。
     * 你开始旅程时，气罐是空的。回到起始加油站的指数，选择一个起点开始旅游，如果你能在
     * 周围环形旅行一次，就返回开始的加油站索引，否则返回-1。
     *
     * 注意：
     *   - 答案保证是唯一的
     *
     * 解题思路
     * 假设从站点 i 出发，到达站点 k 之前，依然能保证油箱里油没见底儿，从k 出发后，见底儿了。
     * 那么就说明 diff[i] + diff[i+1] + ... + diff[k] < 0，而除掉diff[k]以外，从diff[i]
     * 开始的累加都是 >= 0的。也就是说diff[i] 也是 >= 0的，这个时候我们还有必要从站点 i + 1
     * 尝试吗？仔细一想就知道：车要是从站点 i+1出发，到达站点k后，甚至还没到站点k，油箱就见底
     * 儿了，因为少加了站点 i 的油。。。
     *
     * 因此，当我们发现到达k 站点邮箱见底儿后，i 到 k 这些站点都不用作为出发点来试验了，肯定
     * 不满足条件，只需要从k+1站点尝试即可！因此解法时间复杂度从O(n2)降到了 O(2n)。之所以是
     * O(2n)，是因为将k+1站作为始发站，车得绕圈开回k，来验证k+1是否满足。
     *
     * 等等，真的需要这样吗？
     * 我们模拟一下过程：
     * a. 最开始，站点0是始发站，假设车开出站点p后，油箱空了，
     *      假设sum1 = diff[0] +diff[1] + ... + diff[p]，可知sum1 < 0；
     *
     * b. 根据上面的论述，我们将p+1作为始发站，开出q站后，油箱又空了，
     *      设sum2 = diff[p+1] +diff[p+2] + ... + diff[q]，可知sum2 < 0。
     *
     * c. 将q+1作为始发站，假设一直开到了未循环的最末站，油箱没见底儿，
     *      设sum3 = diff[q+1] +diff[q+2] + ... + diff[size-1]，可知sum3 >= 0。
     *
     * 要想知道车能否开回 q 站，其实就是在sum3 的基础上，依次加上 diff[0] 到 diff[q]，
     * 看看sum3在这个过程中是否会小于0。但是我们之前已经知道 diff[0] 到 diff[p-1] 这段路，
     * 油箱能一直保持非负，因此我们只要算算sum3 + sum1是否 <0，就知道能不能开到 p+1站了。
     * 如果能从p+1站开出，只要算算sum3 + sum1 + sum2 是否 < 0，就知都能不能开回q站了。
     *
     * 因为 sum1, sum2 都 < 0，因此如果 sum3 + sum1 + sum2 >=0 那么
     * sum3 + sum1 必然 >= 0，也就是说，只要sum3 + sum1 + sum2 >=0，车必然能开回q站。
     * 而sum3 + sum1 + sum2 其实就是 diff数组的总和 Total，遍历完所有元素已经算出来了。
     * 因此 Total 能否 >= 0，就是是否存在这样的站点的 充分必要条件。
     *
     * 这样时间复杂度进一步从O(2n)降到了 O(n)。
     * </pre>
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 参数检验
        if (gas == null || cost == null || gas.length == 0 || gas.length != cost.length) {
            return -1;
        }

        // 记录访问的起始点
        int start = 0;
        // 加的气和消耗的气的总差值
        int total = 0;
        // 从start位置开始，加的气和消耗的气的总差值
        int sum = 0;

        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);

            // 如是油箱没有油了
            if (sum < 0) {
                // 重新设置油箱中的油
                sum = gas[i] - cost[i];
                // 记录新的起点位置
                start = i;
            } else {
                // 油箱中还有油，更新油箱中的油数
                sum += (gas[i] - cost[i]);
            }
        }

        return total >= 0 ? start : -1;
    }


    // 下面的方法会超时O(N^2)时间复杂度
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        // 参数检验
        if (gas == null || cost == null || gas.length == 0 || gas.length != cost.length) {
            return -1;
        }

        // 剩下的气体，开始时为0
        int leftGas = 0;
        // 开始出发的站点
        int start = 0;
        // 结束的站点
        int end = 1;

        // 未走一周
        while (start < gas.length) {

            // 到达下一个站后的气体简便量
            leftGas = gas[start] - cost[start];

            // 可以走到下一个站
            if (leftGas > 0) {
                // 记录下一个站
                end = (start + 1) % gas.length;

                // 如果一直可以到下一个站就持续进行操作
                while (start != end && (leftGas += (gas[end] - cost[end])) >= 0) {
                    end = (end + 1) % gas.length;
                }

                // 说明已经遍历了一周
                if (start == end) {
                    return start;
                }
            }

            start++;
        }

        return -1;
    }
}
