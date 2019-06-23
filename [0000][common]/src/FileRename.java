import java.io.File;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-14 10:00
 **/
public class FileRename {
    public static void main(String[] args) {
        String pathName = "/Users/wangjunchao/Project/leetcode";
        File path = new File("/Users/wangjunchao/Project/leetcode");

        File[] files = path.listFiles();
        renameFile(files);
    }

    public static void renameFile(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                renameFile(f.listFiles());
            }
        }

        for (File f : files) {
            String name = f.getName();
            name = name.replaceFirst("\\[", "[0");
            System.out.println(name);
            f.renameTo(new File(f.getParent() + "/" + name));
        }
    }
}
