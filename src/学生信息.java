public class 学生信息 {
    public static final int N = 20;
    public static void main(String[] args){
        Student[] s = new Student[N];
        int i;

        for(i = 0;i < N;i++){
            s[i] = new Student();
            s[i].number = (int)(Math.random() * 20) + 1;
            int j;
            for(j = 0;j < i;j++){
                if(s[i].number == s[j].number){
                    j = -1;
                    s[i].number = (int)(Math.random() * 20) + 1;
                }
            }
            s[i].score = (int)(Math.random() * 100) + 1;
            s[i].state = (int)(Math.random() * 6) + 1;
        }

        int j;
        for(i = 0;i < N - 1;i++){
            int l = i;
            for(j = i;j < N;j++){
                if(s[j].number < s[l].number){
                    l = j;
                }
            }
            if(i != l){
                Student t = s[l];
                s[l] = s[i];
                s[i] = t;
            }
        }

        for(i = 0;i < N;i++){
            System.out.println(s[i].puts());
        }

        System.out.println("**************************");

        for(i = 0;i < N;i++){
            if(s[i].state == 3){
                System.out.println(s[i].puts());
            }
        }
    }
}
class Student{
    int number;
    int state;
    int score;

    public String puts(){
        return "学号:" + number + "\t年纪:" + state + "\t成绩:" + score;
    }
}
