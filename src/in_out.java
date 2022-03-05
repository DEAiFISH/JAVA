import java.util.*;
public class in_out{
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		System.out.print("What is your name?");
		String name = in.nextLine();
		System.out.print("How old are u?");
		int age = in.nextInt();
		System.out.println("Hello, " + name + ",Next Year,you'll be " + (age + 1));
		System.out.printf("%tc",new Date());
		//System.out.printf("Hello,%s,Next Year,you'll be %d",name,age + 1);
		/**
		 *print\println\printf的区别print将它的参数显示在命令窗口，并将输出光标定位在所显示的最后一个字符之后。
		 *println 将它的参数显示在命令窗口，并在结尾加上换行符，将输出光标定位在下一行的开始。
		 *printf是格式化输出的形式。
		 */
	}
}