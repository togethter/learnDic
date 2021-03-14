func pi()->Double {
    return 3.14
}
// 函数文档注释
/// 求和[概述]
///
/// 讲2个整数相加[更详细的描述]
/// 
/// - Parameter v1; 第一个参数
/// - parameter v2:第二个参数
/// - Returns:2个整数的和
/// - Note:传入2个整数即可[批注]
func sum( v1:Int,v2:Int) -> Int {
    return v1 + v2
}

// 形参默认是let，也只能是let
sum(v1:10,v2:20)

func sss() ->Void {
    
}
/*
 // 无返回值 这里的三种是一种类型
 
func sayHello() -> Void {
    print("Hello")
}

func sayHello() -> () {
    print("Hello")
}
func sayHello() {
    print("Hello")
}
 */


/**
 // 隐式返回
 如果整个函数体是一个单一表达式，那么函数会隐式返回这个表达式
 */

func sum1(v1:Int,v2:Int) -> Int {
    v1 + v2
}
sum1(v1: 10, v2: 40) // 30

// 返回元祖：实现多返回值
func caculate(v1:Int,v2:Int) ->(sum:Int,difference:Int,average:Int){
    let sum = v1 + v2
    return (sum,v1-v2,sum >> 1)
}


let result = caculate(v1: 5, v2: 1)
result.sum // 30
result.difference // 10
result.average // 15

// 参数标签
func goToWork(at time:String) {
    print("this time is \(time)")
}
goToWork(at: "08:00")
func gotoSchool(time:String) {
    print("this time is \(time)")
}
// 默认参数值
func check(name:String = "nobody",age:Int,job:String = "none") {
    print("name\(name),age=\(age),job=\(job)")
}
check(name: "Jack", age: 20, job: "Doctor")
check(name: "Rose", age: 18)
check(age: 15)

// C++ 的默认参数值有个限制：必须从右往左设置。由于swift拥有参数标签，因此并没有此类限制
// 但是在省略参数标签时，需要特别注意，避免出错
func test(_ first:Int = 10,middle:Int,_ last:Int = 30){
    
}
test(middle: 20)

// 可变参数
func sum_1(_ numbers:Int ...) -> Int {
    var total = 0
    for number in numbers {
        total += number
    }
    return total
}
sum_1(10,20,30,40)

//Swift 自带的print函数
print(1,2,3,4,5)// 1 2 3 4 5
print(1,2,3,4,5, separator: "_")
print("My name is jake.", terminator: "")
print("My age is 18")


func swapValues(_ v1: inout Int,_ v2: inout Int) {
    let tmp = v1
    v1 = v2
    v2 = tmp
}
var num1 = 10
var num2 = 20
swapValues(&num1, &num2)
print("num1=\(num1),num2=\(num2)")

func swapValue_1(_ v1:inout Int,_ v2: inout Int) {
    (v1,v2) = (v2,v1)
}

// 函数重载
/**
 函数名相同
 参数个数不同 || 参数类型不同||参数标签不同
 */
func sumoverload(v1:Int,v2:Int) -> Int {
    v1 + v2
}

func sumoverload(v1:Int,v2:Int,v3:Int) -> Int {
    v1 + v2 + v3
}
func sumoverload(v1:Int,v2:Double)-> Double {
    Double(v1) + v2
}

func sumoverload(v1:Double,v2:Int) -> Double {
    v1 + Double(v2)
}

func sumoverload(_ v1: Int, _ v2:Int) -> Int {
    v1 + v2
}

func sumoverload(a:Int,b:Int)-> Int {
    a + b
    // 参数标签不同
}

// 函数重载注意点
/**
 返回值类型与函数重载无关
 func sum2(v1: Int,v2:Int) -> {v1+v2}
 func sum2(v1:Int,v2:Int) {}
 sum2(v1: <#T##Int#>, v2: <#T##Int#>)
 */
func sum3(v1:Int,v2:Int) -> Int {v1 + v2}
func sum3(v1:Int,v2:Int,v3:Int = 10) -> Int{
    v1 + v2 + v3
}
// 会调用sum(v1:Int,v2:Int)
sum3(v1: 10, v2: 20)

// 可变参数、省略参数标签、函数重载一起使用产生二义性时，编译器有可能会报错
func sum4(v1:Int,v2:Int) -> Int {
    v1 + v2
}
func sum4(_ v1:Int,_ v2:Int) -> Int {
    v1 + v2
}
func sum4(_ numbers:Int...) -> Int {
    var total = 0
    for number in numbers {
        total += number
    }
    return total
}

sum4(v1: 10, v2: 20)
sum4(1,2,3,4,5)

// 每一个函数都有函数类型的，函数类型由形式参数类型，返回值类型组成
func test() {} // () -> Void 或者 ()-> ()
func sum5(a:Int,b:Int) -> Int {
    a + b
}// (Int,Int) -> Int

// 定义变量
var fn:(Int,Int) -> Int = sum5

fn(2,3)// 5，调用时不需要参数标签

