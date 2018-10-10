/**
 * <pre>
 * The isBadVersion API is defined in the parent class VersionControl.
 *       boolean isBadVersion(int version);
 * </pre>
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 14:26
 **/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        if (!isBadVersion(n)) {
            return 0;
        }

        int hi = n;
        int lo = 1;
        int mid;

        while (hi >= lo) {
            mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                // 当前是1号版本，或者前一个是合法版本，那么当前版本就是第一个非法的版本
                if (mid == 1 || (mid > 1 && !isBadVersion(mid - 1))) {
                    return mid;
                } else {
                    // 非法的版本在[lo, mid-1]间
                    hi = mid - 1;
                }
            } else {
                // 非法版本在[mid + 1, hi]间
                lo = mid + 1;
            }
        }

        return 0;
    }
}
