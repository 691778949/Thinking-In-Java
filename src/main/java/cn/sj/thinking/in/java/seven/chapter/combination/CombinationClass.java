package cn.sj.thinking.in.java.seven.chapter.combination;

class Soap{
    private String s;
    public Soap(){
        System.out.println("Soap()");
        s="Constructed";
    }

    @Override
    public String toString() {
        return "Soap{" +
                "s='" + s + '\'' +
                '}';
    }
}
public class CombinationClass {

    private Soap soap;

    public CombinationClass(){
        soap=new Soap();
    }

    @Override
    public String toString() {
        return "CombinationClass{" +
                "soap=" + soap +
                '}';
    }

    public static void main(String[] args) {

        CombinationClass combinationClass=new CombinationClass();
        System.out.println(combinationClass);
    }
}