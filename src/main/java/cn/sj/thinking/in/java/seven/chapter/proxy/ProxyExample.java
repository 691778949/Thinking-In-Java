package cn.sj.thinking.in.java.seven.chapter.proxy;

class ProxyClass{
    public void go(int velocity)
    {
        System.out.println("Go in "+velocity+" km/h speed.");
    }
}
public class ProxyExample {

    private String name;

    private ProxyClass controlProxy=new ProxyClass();

    public void go(int velocity){
        this.controlProxy.go(velocity);
    }

    public ProxyExample(String name){
        this.name=name;
    }

    public static void main(String[] args) {
        ProxyExample proxyExample=new ProxyExample("Space Walk");
        proxyExample.go(60);
    }

}