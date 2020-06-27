import java.util.HashSet;
import java.util.Set;

/**
 * Author: ������
 * Date: 2015-06-18
 * Time: 09:40
 * Declaration: All Rights Reserved !!!
 */
public class Solution {


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the
     * array, and it should return false if every element is distinct.
     * <p>
     * ��Ŀ���⣺����һ���������飬�ж��������Ƿ�����ظ�Ԫ�ء��������������һ�����ֳ������������Σ�
     * ��ĺ���Ӧ�÷���true�����ÿһ��Ԫ�ض���Ψһ�ģ�����false��
     * <p>
     * ����˼·����set���ݽṹ
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        // Ԫ�ظ�������1�Ž�������Ĳ���
        if (nums != null && nums.length > 1) {
            //����һ��hashSet
            Set<Integer> set = new HashSet<>(nums.length);
            for (int i : nums) {
                // ���Ԫ���Ѿ����ھͷ���true
                if (set.contains(i)) {
                    return true;
                }
                // û�о���ӵ�Ԫ�ؼ�����
                else {
                    set.add(i);
                }
            }
        }

        return false;
    }
}
