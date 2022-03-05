public class 值传递 {
    public static void main(String[] args){
        int a = 100;
        int b = 20;
        method(a,b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
    static void method(int a,int b){
        a *= 100;
        b *= 100;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.exit(1);
    }
}
