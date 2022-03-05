import java.util.Scanner;

public class Sine之舞 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Bn(n);
    }
    public static void An(int an){
        for(int i = 1; i <= an; i++){
            System.out.print("sin(" + i);
            if(i % 2 != 0){
                System.out.print("-");
            }
            else{
                System.out.print("+");
            }
        }
        System.out.print("\b");
        for(int i = 0; i < an; i++){
            System.out.print(")");
        }
    }
    public static void Bn(int bn){
        for(int i = 2; i < bn; i++){
            System.out.print("(");
        }
        for(int i = 0; i < bn; i++){
            An(i + 1);
            System.out.print("+" + (bn - i) + ")");
        }
        System.out.print("\b\n");
    }
}