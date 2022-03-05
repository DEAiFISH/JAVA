public class 类型转换 {
    public static void main(String[] args){
        int i = 123;
        Integer j = i;
        System.out.println(i +" " + j); //123 123

        int k = j.intValue();
        System.out.println(k); //123

        String c = i + "";
        System.out.println(c.getClass() + "    " + c); //class java.lang.String    123

        j = Integer.parseInt(c);
        System.out.println(j.getClass() + "    " + c); //class java.lang.Integer    123


    }
}
