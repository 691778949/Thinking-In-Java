##  访问权限控制 

Chapter6 P109

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

