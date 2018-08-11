package cn.sj.thinking.in.java.six.chapter.singleton;

class SingletonClass {

    private static SingletonClass singletonClass=new SingletonClass();

    public static SingletonClass Access(){
        return singletonClass;
    }

    public void f(){
        System.out.println("function f()");
    }

}
public class SingletonExample{

    public static void main(String[] args) {
        SingletonClass.Access().f();
    }

}