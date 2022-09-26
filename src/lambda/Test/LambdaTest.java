package lambda.Test;

import org.junit.Test;

import java.util.Comparator;

/**
 * lambda表达式举例
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱乐山");
            }
        };

        r1.run();

        System.out.println("*****************");

        Runnable r2 = () -> System.out.println("我爱乐山");

        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> c1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(c1.compare(11, 22));

        System.out.println("***************");
        //Lambda表达式的写法
        Comparator<Integer> c2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(c2.compare(11, 22));

        System.out.println("***************");
        //方法引用
        Comparator<Integer> c3 = Integer :: compareTo;

        System.out.println(c3.compare(11, 22));
    }
}
