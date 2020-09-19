package Test;

import day1.Calculator;

public class CalculatorTest {

    /*
    初始化方法
    用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
//    @Before
    public void init() {
        System.out.println("init...");
    }
    /*
    释放资源的方法：
    在所有测试方法执行完后，都会自动执行该方法
     */
//    @After
    public void close() {
//        System.out.println("close...");
    }


    /*
    测试Add方法
    后期再看
     */
//    @Test
    public void testAdd() {
        // 1、创建计算器对象
        Calculator c = new Calculator();
        // 2、调用add方法
        int result = c.add(1, 2);
        System.out.println(result);
        // 断言 我断言这个结果的3
//        Assert.assertEquals(expected:3,result);
    }

    /*
    测试sub方法
    后期再看
     */
//        @Test
    public void testSub() {
        // 1、创建计算器对象
        Calculator c = new Calculator();
        int sub = c.sub(1, 3);
        System.out.println("testsub...");
        System.out.println(sub);
//        Assert.assertEquals(expected:-1,result);

    }
}
