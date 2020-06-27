/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 14:27
 **/
public class VersionControl {

    private boolean[] badVersion;

    public boolean isBadVersion(int version) {
        return badVersion[version - 1];
    }

    public boolean[] getBadVersion() {
        return badVersion;
    }

    public void setBadVersion(boolean[] badVersion) {
        this.badVersion = badVersion;
    }
}
