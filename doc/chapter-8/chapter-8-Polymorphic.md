#  多态

*chapter8 P148*

**在面向对象的程序设计语言中，多态是继数据抽象和继承之后的第三种基本特征。**

###  1.向上转型

```java
enum Note{
    MIDDLE_C,C_SHARP,B_FLAT;
}

class Instrument{

    public void play(Note note){
        System.out.println("Instrument.play()");
    }

}
class Wind extends Instrument{
    public void play(Note note){
        System.out.println("Wind.play() "+note);
    }
}
class Stringed extends Instrument{
    public void play(Note note){
        System.out.println("Stringed.play() "+note);
    }
}
class Music{
    public static void tune(Instrument instrument){
        instrument.play(Note.MIDDLE_C);
    }
}
public class PolymorphicExample {
    public static void main(String[] args) {
        Wind wind=new Wind();
        Music.tune(wind);
        Stringed stringed=new Stringed();
        Music.tune(stringed);
    }
}

/*
Output:
Wind.play() MIDDLE_C
Stringed.play() MIDDLE_C
*/
```

