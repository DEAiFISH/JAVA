package ThreadTest;

import static java.lang.System.out;

/**
 * 多线程的创建，方法一：继承Thread类
 * 1.创建一个继承与Thread类的子类
 * 2.重写Thread的子类 --> 将此线程执行的操作声明写在run()中
 * 3.创建Thread类的字类的对象
 * 4.通过此对象调用start()
 *
 * 
 * 
 * ----Threa中的常用方法 
 * 1、start() ： 启动当前线程；调用当前线程的run()
 * 2、run() ： 通常需要重写Thread类重的此方法，将创建的线程要执行的操作声明在此方法中
 * 3、currentTread() ： 静态方法，返回执行当前代码的线程
 * 4、getName() ： 获取该线程的名字
 * 5、setName() ： 设置该线程的名字
 * 6、yield() ： 释放当前cpu的执行权
 * 7、jion() ：在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行之后，线程a才结束阻塞状态
 * 8、stop() : 强制线程生命期结束，不推荐使用
 * 9、sleep(long millitime) ：让当前线程"睡眠"指定的毫秒，在指定毫秒时间内该线程是阻塞态
 * 9、bolean isAlive() ： 返回boolean，判断线程是否还活着
 *
 *
 *
 * ----Thread的优先级
 * 1、MAX_PRIORITY ： 10
 *   MIN_PRIORITY ： 1
 *   NORM_PRIORITY ： 5 --> 默认优先级
 * 2、如何获取和设置当前线程的优先级
 *  setPriority(int p) ： 设置线程的优先级
 *  getPriority ： 获取当前线程的优先级
 *
 *
 *
 *  ---------练习 ： ThreadTest.WindowTest1.java
 */

public class Multithreading1 {
    public static void main(String[] args){
         // 3.创建Thread类的字类的对象
        MyThread thread1 = new MyThread();
         // 4.通过此对象调用start()  1、启动当前前线程 2、调用当前线程的润run()
        thread1.start();

        //再建立一个线程,不能再使用t1的start()
        MyThread thread2 = new MyThread();
        thread2.start();

        //  ** 创建Tread类的匿名子类的方法
        new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 100; i++){
                    if(i % 2 == 0){
                        out.println(Thread.currentThread().getName() + "---" + i);
                    }
                    if(i == 20){
                        try {
                            sleep(1000 * 3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();




        // 如下线程是在main()方法中执行的。
        Thread.currentThread().setName("主线程");
        for(int i = 0; i < 100; i++){
            if(i % 2 != 0){
                out.println(Thread.currentThread().getName() + ":" + i);
            }
            if(i == 20){
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//1.创建一个Tread类的的子类
class MyThread extends Thread {
     // 2.重写Thread的子类
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
