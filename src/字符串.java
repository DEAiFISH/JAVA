import java.util.StringTokenizer;

public class 字符串 {
    public static void main(String[] arg){
        char a[] = {'a','b','c'};
        String s = new String(a);

        String s1 = new String("abc");

        String s2 = new String(a,0,3);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("########################");
        System.out.println("字符串连接" + s + s1 + s2);
        System.out.println("字符串s + s1 + s2 的长度：" + (s + s1 + s2).length());
        System.out.println("########################");
        System.out.println("字符串索引");
        System.out.println("第一次搜索到的下标indexOf()：" + (s + s1 + s2).indexOf("a"));
        System.out.println("最后一次一次搜索到的下标lastIndexOf()：" + (s + s1 + s2).lastIndexOf("a"));
        System.out.println("获取指定下标的字符charAt():" + (s + s1 + s2).charAt(4));

    }
}
