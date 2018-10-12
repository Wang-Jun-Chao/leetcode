/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-12 14:17
 **/
public class Test {
    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
        System.out.println(array.sumRange(0, 5));
    }
}
