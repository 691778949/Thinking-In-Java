package cn.sj.thinking.in.java.five.chapter.function;

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
