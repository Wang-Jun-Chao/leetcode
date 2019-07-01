/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-01 16:15
 **/
public class WithException {
    public static int withException() {
        int i = 10;
        try {
            System.out.println("i in try block is： " + i);
            i = i / 0;
            return --i;
        } catch (Exception e) {
            System.out.println("i in catch - form try block is: " + i);
            --i;
            System.out.println("i in catch block is: " + i);
            return --i;
        } finally {
            System.out.println("i in finally - from try or catch block is -- " + i);
            --i;
            System.out.println("i in finally block is -- " + i);
            return --i;
        }
    }

    public static void main(String[] args) {
        withException();
    }
}
