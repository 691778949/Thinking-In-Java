package cn.sj.thinking.in.java.eight.chapter;

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
