public class 九九乘法表 {
    public static void main(String[] arg){
        for(int i = 1;i <= 9;i++)
        {
            for(int j = 1;j <= i;j++)
            {
                System.out.print(i + " * " + j + " = " + i * j + "  ");
            }
            System.out.println();
        }
    }
}