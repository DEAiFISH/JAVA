public class TryCatchFinally {
    public static void main(String[] args){
        fun();
        method();
        System.out.println("...");
    }

    public static void fun(){
        int[] array = new int[2];
        try{
            System.out.println(array[2]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("数组索引超出范围");
        }catch(Exception e){

        }finally{
            System.out.println("我是一定要执行的。。。。");
        }
    }

    public static void method(){
        try {
            Throws();
        } catch (NumberFormatException e) {
            System.out.println("数字格式异常。");
        }
    }

    public static void Throws() throws NumberFormatException{
        String s ="abc";
        int num = Integer.parseInt(s);
    }
}
