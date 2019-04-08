package test;

/**
 * @author Jery
 * @date 2019/4/3 14:02
 */
public class SynchronizedTest1 implements Runnable {
    static SynchronizedTest1 instance = new SynchronizedTest1();
    Object object1 = new Object();
    Object object2 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finished");
    }

    @Override
    public void run() {

        synchronized (object1) {
            try {
                System.out.println(Thread.currentThread().getName() + "开始运行");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (object2) {
            try {
                System.out.println(Thread.currentThread().getName() + "获取到值，开始运行");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "运行结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
