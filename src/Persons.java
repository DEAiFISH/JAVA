public class Persons {
    public static void main(String[] args){
        Boy boy1 = new Boy("罗密欧",21);
        boy1.shout();

        Girl girl1 = new Girl("朱丽叶",18);
        girl1.marry(boy1);

        Girl girl2 = new Girl("祝英台",20);
        int compare = girl2.compare(girl1);
        if(compare > 0){
            System.out.println(girl2.getName() + "年龄大");
        }
        else if(compare == 0){
            System.out.println(girl2.getName() + "和" + girl1.getName() + "的年龄一样大");
        }
        else{
            System.out.println(girl2.getName() + "年龄小");
        }
    }
}


class Boy{
    private String name;
    private int age;

    public Boy(){
    }
    public Boy(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void marry(Girl girl){
        System.out.println("我想跟" + girl.getName() + "结婚。");
    }
    public void shout(){
        if(this.age >= 22){
            System.out.println("你可以合法去登记了！");
        }
        else{
            System.out.println("先多谈谈恋爱～～～");
        }
    }
}

class Girl{
    private String name;
    private int age;

    public Girl(){
    }
    public Girl(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void marry(Boy boy){
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }
    public void marry(Girl girl){
        System.out.println("我想跟" + girl.getName() + "结婚。");
    }

    /**
     *
     * @param girl
     * @return 正数：当前对象大；         负数：当前对象小；        0：当前对象与形参对象相等；
     */
    public int compare(Girl girl){
        return this.age - girl.age;
    }
}

