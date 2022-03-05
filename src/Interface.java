public class Interface {
    public static void main(String[] args){
        System.out.println(Flyable.maxSpeed);
        System.out.println(Flyable.minSpeed);

        Plane plane = new Plane();
        plane.Fly();
        plane.Stop();

        Bullet bullet = new Bullet();
        bullet.Fly();
        bullet.Stop();
    }
}

/**
 * 接口
 */
interface Flyable{
    public static final int maxSpeed = 7900;
    //全局常量可以省略 public static final
    int minSpeed =0;
    public abstract void Fly();
    //抽象方法可以省略 abstract public
    void Stop();
}

/**
 * 接口的实现
 */
class Plane implements Flyable{
    @Override
    public void Fly(){
        System.out.println("通过引擎飞。");
    }
    @Override
    public void Stop(){
        System.out.println("停在飞机场");
    }
}

class Bullet implements Flyable{
    @Override
    public void Fly(){
        System.out.println("飞得很快。");
    }

    @Override
    public void Stop() {
        System.out.println("撞击后停下。");
    }
}

