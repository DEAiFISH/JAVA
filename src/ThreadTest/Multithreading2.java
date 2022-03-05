package ThreadTest;

/**
 * 创建多线程的方法二： 实现Runnable接口
 * 1、 创建一个实现了Runnable接口的类
 * 2、 实现类趋势线Runnable重的抽象方法：run()
 * 3、 创建实现类的对象
 * 4、 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5、 通过Thread类的对象调用start()方法
 *
 *
 *
 * ----线程安全问题的解决方法
 * 方法一：同步代码块
 *
 *   synchronized(同步监视器){
 *       //需要同步的代码
 *   }
 *   说明 ： 1、操作共享数据的代码，即为需要被同步的代码  --->  不能包含多了，也不能少了
 *          2、共享数据 ：多个线程共同操作的变量。比如：ticket就是共享数据
 *          3、同步监视器，俗称：锁  任何一个类的对象都可以为一个锁
 *              要求：多个线程必须共用一把锁
 *          补充：在实现Runnable接口创建多线程方式中，我们可以考虑使用this来充当同步监视器
 *
 * 方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的
 *
 *      列： 1、 使用同步方法来解决Runnable接口的问题
 *          void run(){
 *              show();
 *          }
 *          private synchronized void show(){
 *              //需要同步的代码块
 *          }
 *
 *
 *          2、 使用同步方法来解决Runnable接口的问题
 *          void run(){
 *              show();
 *          }
 *          private static synchronized void show(){
 *              //需要同步的代码块
 *          }
 *
 *       关于同步方法的总结：
 *          1、同步方法涉及同步监视器没，只是不需要我们显示的声明
 *          2、非静态的同步方法，同步监视器是 ： this
 *             静态的同步方法，同步监视器是 ： 当前类本身
 *
 *
 *
 *  同步的方式，解决了线程的安全问题 --- 好处
 *  操作同步代码时，只能一个线程参与，其他线程等待，相当于一个但线程的线程，效率低 --- 局限
 */

public class Multithreading2 {
    public static void main(String[] args){
        //3、创建实现类对象
        MyThread mThread = new MyThread();
        //4、将此对象作为阐述传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        //5、通过Thread类的对象调用start()： 启动线程，调用当前线程的run()
        t1.start();
    }
}

//1、创建一个实现了Runnable类的接口
class MThread implements Runnable {

    //2、实现类趋势线Runnable中的抽象方法：run()
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
