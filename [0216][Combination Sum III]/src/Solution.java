import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-21
 * Time: 21:31
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination
     * should be a unique set of numbers.
     *
     * Ensure that numbers within the set are sorted in ascending order.
     *
     * Example 1:
     * Input: k = 3, n = 7
     * Output:
     * [[1,2,4]]
     *
     * Example 2:
     * Input: k = 3, n = 9
     * Output:
     * [[1,2,6], [1,3,5], [2,3,4]]
     *
     * ��Ŀ���⣺
     * Ѱ����������k����֮�͵���n����ϣ�ֻ����ʹ������1-9������ÿһ������е�����Ӧ����Ψһ�ġ�
     * ȷ������е������Ե���˳�����С�
     *
     * ����˼·��
     * ���ݷ�
     * </pre>
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        // ���ڱ������н��
        List<List<Integer>> result = new LinkedList<>();
        // ���ڱ����м���
        List<Integer> list = new LinkedList<>();
        // ��������ͽ��н������
        if (k > 0 && k <= 9) {
            solve(k, 1, n, 0, list, result);
        }

        // ���ؽ��
        return result;
    }

    /**
     * ��ⷽ��
     *
     * @param k         ÿ�����Ԫ�ظ���
     * @param cur       ��ǰ�����k��Ԫ��
     * @param remainder k - cur + 1��Ԫ�صĺ�
     * @param prevVal   ��cur-1��Ԫ�ص�ȡֵ
     * @param list      �����Ԫ�صļ�����
     * @param result    �������н��������
     */
    public void solve(int k, int cur, int remainder, int prevVal, List<Integer> list, List<List<Integer>> result) {
        // �������һ��Ԫ��
        if (cur == k) {
            // remainderΪ���һ����Ԫ�ص�ֵ�����������ǰһ����Ԫ�ص�ֵ�����Ҳ��ܳ���9
            if (remainder > prevVal && remainder <= 9) {
                // ���Ԫ��ֵ
                list.add(remainder);

                // ����������µĶ�����
                List<Integer> one = new LinkedList<>();
                for (Integer i : list) {
                    one.add(i);
                }

                // ������
                result.add(one);
                // ɾ�����һ��Ԫ�أ������ֳ���ԭ
                list.remove(list.size() - 1);
            }
        }
        // �������һ��Ԫ��
        else if (cur < k) {
            for (int i = prevVal + 1; i <= 9 - (k - cur); i++) {
                // ���Ԫ��
                list.add(i);
                // �ݹ����
                solve(k, cur + 1, remainder - i, i, list, result);
                // �ֳ���ԭ
                list.remove(list.size() - 1);

            }
        }


    }
}
