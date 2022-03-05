
public class BreakCyc {
    public static void main(String[] arg) {
        System.out.println("\n-----中断单程循环的例子------");
        String[] array = new String[]{"白鹭", "丹顶鹤", "黄莺", "鹦鹉", "乌鸦", "喜鹊"};
        System.out.print("在你发现第一只老鹰之前，告诉我都看见了什么鸟：");
        for (String string : array) {
            if (string.equals("老鹰")) {
                break;
            }
            System.out.print("有：" + string + "   ");
        }

        System.out.println("\n-----中断双程循环的例子------");
        int[][] myScores = new int[][]{{67, 78, 63, 22, 66},
                {55, 68, 78, 95, 44},
                {95, 97, 92, 93, 81}};
        System.out.println("宝宝这次的成绩：\n数学\t语文\t英语\t美术\t历史");
        No1:
        for (int[] is : myScores) {
            for (int i : is) {
                System.out.print(i + "\t");
                if (i < 60) {
                    System.out.println("\n等等," + i + "分的是什么？这个为什么不及格");
                    break No1;
                }
            }
        }
        System.out.println();
    }

}