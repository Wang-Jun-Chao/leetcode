/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-12 08:44
 **/
public class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                move(arr, i + 1);
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    private void move(int[] arr, int i) {
        if (arr.length - 1 - i >= 0) {
            System.arraycopy(arr, i, arr, i + 1, arr.length - 1 - i);
        }
    }
}
