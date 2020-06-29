import java.util.*;

/**
 * Author: 王俊超
 * Time: 2020-06-29 07:34
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {

    class Rank {
        Rank(int s, int i) {
            this.Score = s;
            this.Index = i;
        }
        int Score;
        int Index;
    }

    /**
     * 题解思路：
     * 1、记录分数对应的下标；
     * 2、对分数进行排序，求行排名
     * 3、再根据分数将原始数组的下标和排名对应起来
     *
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null) {
            return null;
        }

        Rank[] ranks = new Rank[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ranks[i] = new Rank(nums[i], i);
        }

        Arrays.sort(ranks, new Comparator<Rank>() {
            @Override
            public int compare(Rank o1, Rank o2) {
                return -(o1.Score - o2.Score);
            }
        });

        String[] result = new String[nums.length];
        for (int i = 0; i < ranks.length; i++) {
            switch (i) {
                case 0:
                    result[ranks[i].Index] = "Gold Medal";
                    break;
                case 1:
                    result[ranks[i].Index] = "Silver Medal";
                    break;

                case 2:
                    result[ranks[i].Index] = "Bronze Medal";
                    break;
                default:
                    result[ranks[i].Index] = "" + (i + 1);
            }
        }
        return result;
    }

    public String[] findRelativeRanks3(int[] nums) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(nums.length + 1); // 使用优先堆，加1是为了防止参数为0

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            queue.add(nums[i]); // 创建小顶堆
        }


        String[] result = new String[nums.length];
        int i = nums.length + 1;
        while (!queue.isEmpty()) {
            int score = queue.poll();
            i--;
            switch (i) {
                case 1:
                    result[map.get(score)] = "Gold Medal";
                    break;
                case 2:
                    result[map.get(score)] = "Silver Medal";
                    break;
                case 3:
                    result[map.get(score)] = "Bronze Medal";
                    break;
                default:
                    result[map.get(score)] = "" + i;
            }

        }

        return result;
    }

    public String[] findRelativeRanks2(int[] nums) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        String[] result = new String[nums.length];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int score = nums[nums.length - 1 - i];
            switch (i) {
                case 0:
                    result[map.get(score)] = "Gold Medal";
                    break;
                case 1:
                    result[map.get(score)] = "Silver Medal";
                    break;

                case 2:
                    result[map.get(score)] = "Bronze Medal";
                    break;
                default:
                    result[map.get(score)] = "" + (i + 1);
            }
        }

        return result;
    }
}
