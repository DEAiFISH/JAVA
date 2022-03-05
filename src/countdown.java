import static java.lang.Math.*;

public class countdown {
    public static void main(String[] args) {
        Clock.printTime();
//        Heart1.print();
    }
}

class Clock{
    public static void printTime(){
        for(int p = 5; p >= 0; p--){
            for (int i = 9; i >= 0; i--){
                for(int j = 5; j >= 0; j--){
                    for(int k = 9; k >= 0; k--){
                        System.out.print(p + "" + i + ":" + j + k);
                        int t = 1;
                        while(t-- != 0){
                            try{
                                System.out.print("\b\b\b " + j + k);
                                Thread.sleep(500);
                                System.out.print("\b\b\b:" + j + k);
                                Thread.sleep(500);
                            }catch(Exception e){
                                System.out.println("Exception");
                            }
                        }
                        System.out.print("\b\b\b\b\b\b");
                    }
                }

            }
        }
    }
}

class Heart1{
    public static void print(){
        float x,y,a;
        char s[]=new char[]{'I',' ','l','o','v','e',' ','y','o','u','!'};
        for(y=1.3f;y>-1.1f;y-=0.06f){
            int index = 0;
            for(x=-1.2f;x<=1.2f;x+=0.025f){
                a=x*x+y*y-1;
                if(a*a*a-x*x*y*y*y < 0){
                    System.out.print("*");
                    index=(index+1)% s.length;
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


}