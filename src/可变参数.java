public class 可变参数 {
    public static void main(String[] args){
        System.out.println(Sum());
    }

    public static int Sum(int...num){
        int i;
        int S = 0;
        for(i = 0;i < num.length;i++){
            S += num[i];
        }
        return S;
    }
}
