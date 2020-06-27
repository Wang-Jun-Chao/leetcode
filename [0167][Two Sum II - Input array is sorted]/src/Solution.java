/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 16:17
 **/
public class Solution {
    /**
     * 如果数组很大，target很小，可以考虑先用二分查找法找到不大于target元素的下标，再作处理
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
//        int idx = search(numbers, target);
        int idx = numbers.length - 1;
        return twoSum(numbers, target, idx);
    }

    public int[] twoSum(int[] numbers, int target, int end) {
        int[] result = {0, 0};

        int lo = 0;
        int hi = end;

        while (lo < hi) {
            if (numbers[lo] + numbers[hi] == target) {
                result[0] = lo;
                result[1] = hi;
                break;
            } else if (numbers[lo] + numbers[hi] > target) {
                hi--;
            } else {
                lo++;
            }
        }

        return result;
    }

    public int search(int[] numbers, int target) {

        int lo = 0;
        int hi = numbers.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }
        return hi;
    }
}
