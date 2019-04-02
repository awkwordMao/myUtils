package utils;

/**
 * @author lijie
 * @since 2019/4/2
 * 倒计时
 */
public class CountDown {

    private static Integer time = 1 * 60;
    private static Integer var1 = 0;

    public static void timer() {
        while (time > 0) {
            time--;
            ++var1;
            try {
                Thread.sleep(1000);
                int hh = time / 60 / 60 % 60;
                int mm = time / 60 % 60;
                int ss = time % 60;
                System.out.println("过去 " + var1 + " 秒，还剩" + hh + ":" + mm + ":" + ss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
