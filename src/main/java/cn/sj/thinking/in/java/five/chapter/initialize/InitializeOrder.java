package cn.sj.thinking.in.java.five.chapter.initialize;

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