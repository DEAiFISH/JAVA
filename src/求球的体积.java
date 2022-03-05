import java.util.*;
public class 求球的体积
{
	public static void main(String[] arg)
	{
		Scanner scan = new Scanner(System.in);
		final double PI = 3.14;
		System.out.print("请输入球半径：");
		double r = scan.nextDouble();
		System.out.println("圆的周长为：" + PI * r * r);
		System.out.printf("球的体积为：" + 4.0 / 3.0 * PI * Math.pow(r,3));
	}
}