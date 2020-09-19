package Annotation;

public @interface MyAnno {
    /**
     * public abstract 默认可以不写
     *
     * @return
     */
//    public abstract String show();
//    String show();
    int value();
    Person per();
    MyAnno2 anno2();
    String[] strs();
    /*String show2();
    String name() default "张三";

    MyAnno2 anno2();

    String[] strs();*/
}
