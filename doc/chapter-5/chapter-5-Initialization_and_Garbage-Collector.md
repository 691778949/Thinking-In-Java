#  初始化与清理

###  1.static方法的内部不能调用非静态方法，反过来倒是可以的

###  2.finalize（）方法：

###  	一旦垃圾回收器准备好释放对象占用的存储空间，将首先调用其finalize()方法，并在下一次垃圾回收动作发生时，才会真正回收对象占用的内存,使用finalize()能在垃圾回收时刻做一些重要的清理工作。

###  3.构造器初始化：

####  在类的内部，变量定义的先后顺序决定了初始化的顺序。即使变量定义散布于方法定义之间，他们仍旧会在任何方法（包括构造函数）被调用之前得到初始化

```java
public class InitializeOrder {


    public static void testOrderOfInitialization(){
        House h=new House();
        //Show constructor is done
        h.f();
    }

    public static void main(String[] args) {
        testOrderOfInitialization();
    }
}
class Window{

    Window(int marker){
        System.out.println("Window("+marker+")");
    }
}

class House{

    //Before constructor
    Window window1=new Window(1);

    House(){

        System.out.println("House()");

        //Reinitialize w3
        w3=new Window(33);
    }

    //After constructor
    Window window2=new Window(2);

    void f(){
        System.out.println("f()");
    }

    //At end
    Window w3=new Window(3);

}
/*
Output：
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
*/
```

###  4.静态数据的初始化：

####  静态初始化只有在必要时刻才会进行。初始化的顺序是先静态对象，而后是“非静态”对象。

#####  Example：

```java
public class StaticInitializeOrder {

    public static void staticInitialization(){
        System.out.println("Create new Cupboard in function \"staticInitialization()\"");
        new Cupboard();
        System.out.println("Create new Cupboard in function \"staticInitialization()\"");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    public static void main(String[] args) {
        staticInitialization();
    }

    static Table table=new Table();
    static Cupboard cupboard=new Cupboard();
}
class Bowl{

    Bowl(int marker){
        System.out.println("Bowl("+marker+")");
    }

    void f1(int marker){
        System.out.println("f1("+marker+")");
    }
}
class Table{

    static Bowl bowl1=new Bowl(1);

    Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker){
        System.out.println("f2("+marker+")");
    }
    static Bowl bowl2=new Bowl(2);
}
class Cupboard{

    Bowl bowl3=new Bowl(3);

    static Bowl bowl4=new Bowl(4);

    Cupboard(){
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker){
        System.out.println("f3("+marker+")");
    }

    static Bowl bowl5=new Bowl(5);
}
/*Output：
Bowl(1)
Bowl(2)
Table()
f1(1)
Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)
Create new Cupboard in function "staticInitialization()"
Bowl(3)
Cupboard()
f1(2)
Create new Cupboard in function "staticInitialization()"
Bowl(3)
Cupboard()
f1(2)
f2(1)
f3(1)
*/
```



###  5.显式的静态初始化（静态块）：

####  与其他静态初始化动作一样，这段代码仅执行一次：当首次生成这个类的一个对象时，或者首次访问属于那个类的静态数据成员时（几遍从未生成过那个类的对象）

#####  Example

```java
public class Example{
    static int i;
    static {
        i=0;
    }
}
```

###  6.非静态实例初始化（初始化非静态变量）：

####  无论调用哪一个构造器，都会执行此代码块

##### Example

```java
public class Example{
    int i;
    {
        i=0;
    }
}
```

###  7.对象数组初始化：

Example

```java
public class ArrayInitialize {

    public static void main(String[] args) {
        Integer[] a=new Integer[]{
            new Integer(1),
            new Integer(2),
            3
        };
        System.out.println("Array a:\t"+Arrays.toString(a));

        Integer []b={
            new Integer(1),
            new Integer(2),
            3
        };

        System.out.println("Array b:\t"+Arrays.toString(b));
    }
}
/*
Output:
Array a:	[1, 2, 3]
Array b:	[1, 2, 3]
*/
```

###  8.一个能容纳多种类型的数组（object[]）

Example

```
Object[] objects=new Object[]{
     new Integer(1),
     new Double(2.2),
     new Float(3.3)
};
System.out.println(Arrays.toString(objects));
/*
Output:
[1, 2.2, 3.3]
*/
```

###  9.可变参数列表：

####  (其重载与一般的函数相同，但当参数个数为0时，编译器就无法知道应该调用哪一个方法了，可以再某个方法中增加一个非可变参数（Ex. printArray1(float requirement,String...strings)）来解决)

```java
public class VariableArgumentLists {

    public static void printArray(Object... objects){
        for(Object object:objects){
            System.out.println(object);
        }
    }

    public static void printArray1(int requirement,String...strings){
        System.out.println("{ \nrequirement: "+requirement+" \nstrings:[");
        for (String string:strings){
            System.out.print(" "+string);
        }
        System.out.println("\n]\n}");
    }

    public static void main(String[] args) {
        printArray(new Object[]{
                new VariableArgumentLists(),
                new Integer(1),
                new Double(2.2)
        });

        printArray(new VariableArgumentLists()
                ,new VariableArgumentLists()
                ,new VariableArgumentLists(),
                new VariableArgumentLists()
        );

        printArray1(2,"one","two");
        printArray1(1,"one");
        printArray1(0);
    }
}
/*
Output:
cn.sj.thinking.in.java.five.chapter.function.VariableArgumentLists@4554617c
1
2.2
cn.sj.thinking.in.java.five.chapter.function.VariableArgumentLists@74a14482
cn.sj.thinking.in.java.five.chapter.function.VariableArgumentLists@1540e19d
cn.sj.thinking.in.java.five.chapter.function.VariableArgumentLists@677327b6
cn.sj.thinking.in.java.five.chapter.function.VariableArgumentLists@14ae5a5
{ 
requirement: 2 
strings:[
 one two
]
}
{ 
requirement: 1 
strings:[
 one
]
}
{ 
requirement: 0 
strings:[

]
}
*/
```

###  10.枚举类型

```java
public class EnumExample {
    public static void main(String[] args) {
        for(NameEnumeration nameEnumeration:NameEnumeration.values()){
            System.out.println(nameEnumeration);
        }

        describe(NameEnumeration.TONY);
    }
    public static void describe(NameEnumeration nameEnumerationReceive){
        System.out.println("**This is function describe(NameEnumeration nameEnumerationReceive)**");
        switch (nameEnumerationReceive){
            case TONY:
                System.out.println("TONY");
                break;
            case BRUCE:
                System.out.println("BRUCE");
                break;
            case HONEY:
                System.out.println("HONEY");
                break;
            case MARRY:
                System.out.println("MARRY");
                break;

                default:
                    System.out.println("It's not in NameEnumeration");
        }
    }
}
enum NameEnumeration {
    MARRY,HONEY,TONY,BRUCE
}
/*
Output:
MARRY
HONEY
TONY
BRUCE
**This is function describe(NameEnumeration nameEnumerationReceive)**
TONY
*/
```