package ThreadTest;

/**
 * 例子 ： 创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 *
 *
 *
 * 比较创建线程的两种方式：
 * 1、开发中优先选择，实现Runnable接口的方式
 *      原因： 1·实现的方式没有类的单继承性的局限性
 *            2·实现的方式跟适合来处理多个线程有共享数据的情况
 * 2、联系 ： Thread类也实现了Runnable接口
 * 3、相同点 : 两种方式都需要重写run()，将线程执行的逻辑声明在run()中
 */

public class WindowTest2 {
    public static void main(String[] args){
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        t1.setName("窗口1");
        Thread t2 = new Thread(w);
        t2.setName("窗口2");
        Thread t3 = new Thread(w);
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


//使用同步代码块来解决Runnable接口的线程安全问题

class Window1 implements Runnable {

    private int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {   //或者 synchronized(obj){
                if (ticket > 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为 ： " + ticket--);
                } else {
                    break;
                }
            }
        }
    }

}

