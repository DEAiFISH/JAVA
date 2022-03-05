import java.util.*;

public class 是否为闰年
{
	public static void main(String[] arg)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("请输入一个年份：");
		long year = scan.nextLong();
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
		{
			System.out.printf("%d是闰年。",year);
		}
		else
		{
			System.out.println(year + "是平年。");
		}
	}
}