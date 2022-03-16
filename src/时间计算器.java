import java.util.*;


public class 时间计算器 {
    public static void main(String[] args) {

        System.out.println("输入你想要计算的日期，格式(yyyy MM dd):");


        Scanner scanner = new Scanner(System.in);
        //记录日期的字符串
        String data = scanner.nextLine();

        ClockDemo(data);

    }


    //计算日期差的函数
    public static void ClockDemo(String data) {
        //已" " 空格为分隔符 把字符串分隔为字符串数组
        String[] dates = data.split(" ");
        //将字符串转换为数字
        int Year = Integer.parseInt(dates[0]);
        int Month = Integer.parseInt(dates[1]) - 1;
        int Day = Integer.parseInt(dates[2]);

        //日历类实例化
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

            //判断要求的时间在今天之前还是之后
            if (nowTime < setTime) {
                //计算两个时间戳的差
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
