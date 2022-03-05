package ThreadTest;

/**
 * 例子 ： 创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 *
 * 说明 ： 在继承Thread类创建多线程方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 */
public class WindowTest1 {
    public static void main(String[] args){
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

//使用同步代码块来解决继承的线程安全问题

class Window extends Thread{

    private static int ticket = 100;
    private static Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
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