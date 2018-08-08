package cn.sj.thinking.in.java.five.chapter.initialize;

import java.util.Arrays;

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

        Object[] objects=new Object[]{
             new Integer(1),
             new Double(2.2),
             new Float(3.3)
        };
        System.out.println(Arrays.toString(objects));
        printArray(objects);
    }

    public static void printArray(Object[]objects){
        for(Object object:objects){
            System.out.println(object);
        }
    }
}
