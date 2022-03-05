import java.util.StringTokenizer;

public class 字符串去掉指定字符串 {
    public static void main(String[] arg){
        String S = "   java class  ";
        System.out.println("去掉字符前面和末尾的空格：trim():" + S.trim());

        String S1 = "  We are students.   ";
        System.out.println("\n原字符串是：" + S1);
        StringTokenizer n_S = new StringTokenizer(S1," "); //去掉字符中所有的空格(delim）
        StringBuffer s =  new StringBuffer();
        int i = 1;
        while(n_S.hasMoreTokens()){
            i++;
            s.append(n_S.nextToken());
        }
        System.out.println("去掉空格后的字符串是：" + s.toString());

        System.out.println("######################");
        System.out.println(n_S);
    }
}
