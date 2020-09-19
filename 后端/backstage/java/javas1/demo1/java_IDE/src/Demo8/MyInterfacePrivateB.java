package Demo8;
/*

 */
public interface MyInterfacePrivateB {

    public static void methodDefault1() {
        System.out.println("静态方法1");
        methodStaticCommon();
    }
    public static void methodDefault2() {
        System.out.println("静态方法2");
        methodStaticCommon();
    }

    private static void  methodStaticCommon(){
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }

}
