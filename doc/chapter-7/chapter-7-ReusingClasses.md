##  复用类

*Chapter7 P125*

###  1.组合

**Example:**

```java
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
/*
Output:
Soap()
CombinationClass{soap=Soap{s='Constructed'}}
*/
```

###  2.继承

###  3.代理

**Example:**

```java
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
/*
Output:
Go in 60 km/h speed.
*/
```

###  4.final关键字

####  修饰函数的参数时，可以读该参数，但却无法修改参数

#####  使用final关键字的原因：

**1.把方法锁定，以防任何继承类修改它的含义**

####  类中所有的private方法都隐式地指定为是final。

###  5.开始一个设计时，一般应优先选择使用组合（或者可能是代理），只在确实必要时才是用继承。

