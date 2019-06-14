import java.util.LinkedList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:50
 **/
public class Solution {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        List<String> result = new LinkedList<>();

        for (String part : ss) {
            if (".".equals(part)) {
                continue;
            } else if ("..".equals(part)) {
                if (result.size() > 0) {
                    result.remove(result.size() - 1);
                }
            } else if (!"".equals(part.trim())) {
                result.add(part);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String part : result) {
            builder.append("/").append(part);
        }

        return builder.length() == 0 ? "/" : builder.toString();
    }
}
