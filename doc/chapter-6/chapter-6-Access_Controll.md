##  访问权限控制 

*Chapter6 P109*

**访问权限控制的两个原因：**

**1.为了使用户不要触碰他们不该触碰的部分，这些部分对于类内部的操作是必要的，但是它并不属于客户端程序员所需接口的一部分。因此将方法和域指定城private，对客户端程序员而言是一种服务。**

**2.为了让类库设计者可以更改类的内部工作方式而不必担心这样会对客户端程序员产生重大的影响**

###  1.package和import关键字的作用是将单一的全局名字空间分隔开。

###  2.静态import导入

```java
/*
* Util Class
*/
package cn.sj.thinking.in.java.six.chapter.utils;

public class StaticUtils {

    public static void println(Object object){
        System.out.println(object.toString());
    }

}
```

```java
/*
* Use static import
*/
package cn.sj.thinking.in.java.six.chapter.access.controll;
import static cn.sj.thinking.in.java.six.chapter.utils.StaticUtils.*;

public class StaticImport {

    public static void main(String[] args) {
        println(new StringBuilder("Static import example"));
    }
}
/*Output:
Static import example

*/
```

###  3.可以在文件中没有public class，可以任意命名文件，但不常用。

###  4.单例模式

Example：

```java
class SingletonClass {

    private static SingletonClass singletonClass=new SingletonClass();
    
    public static SingletonClass Access(){
        return singletonClass;
    }
    
    public void f(){
        System.out.println("function f()");
    }
    
    private int a;
}
public class SingletonExample{
    
    public static void main(String[] args) {
        SingletonClass.Access().f();
        //SingletonClass.Access().a=0; Error! can't access private member in other class which           //doesn't include class "SingletonClass"
    }
    
}
```

###  5.private: 除了包含该成员的类以外，其他任何类都无法访问这个成员

