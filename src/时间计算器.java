import java.util.*;


public class 时间计算器 {
    public static void main(String[] args) {

        System.out.println("输入你想要计算的日期，格式(yyyy MM dd):");

        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();

        ClockDemo(data);

    }

    public static void ClockDemo(String data) {
        String[] dates = data.split(" ");
        int Year = Integer.parseInt(dates[0]);
        int Month = Integer.parseInt(dates[1]) - 1;
        int Day = Integer.parseInt(dates[2]);

        Calendar nowDate = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.CHINA);
        Calendar setDate = Calendar.getInstance();
        setDate.set(Year, Month, Day, 0, 0, 0);

        Date nowD = nowDate.getTime();
        Date setD = setDate.getTime();


        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        boolean flag = false;
        try {
            long nowTime = nowD.getTime();
            long setTime = setD.getTime();
            long diff;
            if (nowTime < setTime) {
                diff = setTime - nowTime;
                flag = true;
            } else {
                diff = nowTime - setTime;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};


        if (!flag) {
            System.out.println("已经过了" + times[0] + "天" + times[1] + "小时" + times[2] + "分钟" + times[3] + "秒");
        } else {
            System.out.println("还剩" + times[0] + "天" + times[1] + "小时" + times[2] + "分钟" + times[3] + "秒");
        }
    }


}
