package cn.sj.thinking.in.java.five.chapter.enumeration;

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