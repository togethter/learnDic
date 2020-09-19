package day1;

public class DemoEquals {
    /*
    Person类继承了Object类所以可以使用Object的Equals方法
    boolean equals(Object object) 其他对象是否与此对象相等
        public boolean equals(Object obj) {
            return (this == obj);
        }
     */
    public static void main(String[] args) {
        Person p1 = new Person("迪丽热巴",18);
        Person p2 = new Person("古力娜招",18);
        boolean b = p1.equals(p2);
        System.out.println(b);

    }


}
