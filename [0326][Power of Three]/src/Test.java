/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-16 15:31
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(Double.doubleToLongBits((int) 1.00000000001)
                == Double.doubleToLongBits(1.00000000001));

        System.out.println(Double.doubleToLongBits((int) 1.00000000000)
                == Double.doubleToLongBits(1.00000000000));
    }
}
