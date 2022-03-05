public class 字符串替换 {
    public static void main(String[] arg){
        String S1 = "  We are students.   ";
        System.out.println("S1 :" + S1);
        System.out.println("S1替换掉所有空格后：" + S1.replaceAll(" ",""));
        System.out.println("replaceAll(,)替换不是永久替换 " + S1);

    }
}
