###  	1.直接操作对象内的域容易导致混乱，并且，违背了良好的面向	对象程序设计的原则。

###  	2.Java中传递的是变量的引用。

```java
public class ApplicationStart {

    public static void modify(int x){
        x=1;
    }
    public static void main(String[] args) {
        int y=3;
        modify(y);
        System.out.println(y);
    }
}
/*
输出结果：
	y=3
	*/
```

###  	3.整数除法会直接去掉结果的小数位，而不是四舍五入地圆整结果。

###   	4.比较两个对象的实际内容是否相同时，必须使用所有对象都适用的特殊方法equals()。

**（equals()的默认行为是比较引用，要在自己的新类中覆盖equals()方法才能实现上述功能）**

##  3.10按位操作符      P49

###  5.逻辑运算&&时，碰到一个false就停止运算

###  6.十六进制数适用于所有整数数据类型，以前缀0x或0X开始。

###  7.Java中 e 代表 10 的幂次。

###  8.按位操作符可以与等号（=）联合使用，以便合并运算和赋值：&=、|=和^=都是合法的。（由于“~”是一元操作符，所以不可与 “=” 联合使用）

###  9.Java int窄转换时，只取整数部分

```java
public class ApplicationStart {
    
    public static void main(String[] args) {
        System.out.println((int)2.9);
    }
}
/*
输出结果：
	2
*/
```

###  需要舍入时，使用java.long.Math中的round()方法：

```java
public class ApplicationStart {

    public static void main(String[] args) {
        System.out.println(Math.round(2.9));
    }
}
/*
输出结果：
	3*/
```

### 10.对基本数据类型执行算术运算或按位运算时，只要类型比int小（即char、byte或者short），那么在运算之前，这些值会自动转换成int，这样一来，最终生成的结果就是int型。

**PS**：（float值与double值相乘，结果为double，将int和long值相加，结果为long）

### 11.Java不需要sizeof()操作符，因为所有数据类型在所有机器中的大小是相同的。

###  12.outer 关键字

####  适用情况

1）一般的continue会退到最内层循环的开头（顶部），并继续执行。

2）带标签的continue会达到标签的位置，并重新进入紧接在那个标签后面的循环。

3）一般的break会中断并跳出当前循环。

4）带标签的break会中断并跳出标签所指的循环。

example:

```java
public class ApplicationStart {

    public static void main(String[] args) {
        int i=0;
        outer:
        while(true){
            System.out.println("Outer while loop!");
            while(true){
                i++;
                System.out.println("i = "+i);
                if(i==1){
                    System.out.println("continue");
                    continue ;
                }
                if(i==3){
                    System.out.println("continue outer");
                    continue outer;
                }
                if(i==5){
                    System.out.println("break");
                    break ;
                }
                if(i==7){
                    System.out.println("break outer");
                    break outer;
                }
            }
        }
    }
}
/*
输出结果：

Outer while loop!
i = 1
continue
i = 2
i = 3
continue outer
Outer while loop!
i = 4
i = 5
break
Outer while loop!
i = 6
i = 7
break outer
*/
```