
// if else
let age = 4
if age > 22 {
    print("get married")
} else if age > 18 {
    print("...")
} else if age > 7 {
    print("go to school")
} else {
    print("just a child")
}


// while
var num = 5
while num > 0 {
    print("....")
    num -= 1
}
// repeat-while 相当于 oc语言中的 do-while
num = -1
repeat {
    print(".....")
} while num > 0
// 这里不用num--,因为swift3.0去掉了自增++,自减--运算符

//for
let names = ["qq","ww","ee","rr"]
for i/*i默认是let*/ in 0 ... 3 {
    print(names[i])
}
// 打印三次
for _/*yongbudao */ in 1...3 {
    print("for")
}

let range = 1...3
for i in range {
    print(names[i])
}




for var/*默认是let，有需要该成var*/ i in 1...3 {
    i += 5;
    print(i)
}
// 半开区间运算符 a..<b，a<=取值<b
for i in 1..<3 {
    print(i)
}


// for区间运算符用在数组上
for name in names[0...3] {
    print(name)
}
// 让区间朝一个方向尽可能的远
for name in names[0...] {
    print(name)
}
for name in names[...3] {
    print(name)
}
for name in names[..<3] {
    print(name)
}

range.contains(7)// false
range.contains(3)
range.contains(-1) // false
print(range.contains(3)) // true


let range1: ClosedRange<Int> = 1...3
let range2:Range<Int> = 1..<3
let range3:PartialRangeThrough<Int> = ...5


// 字符字符串也能使用区间运算符，但默认不能用在for-in中
let stringRange1 = "cc"..."ff"
stringRange1.contains("cb")
stringRange1.contains("dz")
stringRange1.contains("ee")

let stringRange2 = "a"..."f"
stringRange2.contains("g")
stringRange2.contains("e")

// \0到~囊括了所有可能用到的ASII字符
let characterRange:ClosedRange<Character> = "\0"..."~"
characterRange.contains("G")

// 带间隔的区间值
let hours = 11
let hourinterval = 2

for tickMark in stride(from: 4, through: hours, by: hourinterval) {
    print(tickMark)
}

// Case、defalut 后面不能写大括号{},默认可以不写break，并不会贯穿到后面的条件
var number = 1
switch number {
case 1:
    print("number is 1")
case 2:
    print("number is 2")
default:
    print("number is other")
}

// 使用fallthrought可以实现贯穿效果
switch number {
case 1:
    print("number is 1")
    fallthrough
case 2:
    print("number is 2")
default:
    print("number is other")
}

// switch 注意点
/**
 必须要保证能处理所有情况
 case、default后面至少要有一条语句
 如果不想要任何事，加个break即可
 */
switch number {
case 1:
    print("number is 1")
case 2:
    print("number is 2")
default:
    break
}

enum Answer {
    case right,wrong
}
let answer = Answer.right
switch answer {
case Answer.right:
    print("right")
case Answer.wrong:
    print("wrong")    
}

// 复核条件
/**
 switch也支持Character、String类型
 */
let string = "Jack"

switch string {
case "Jack":
    fallthrough
case "Rose":
    print("Right person")
default:
    break
}

switch string {
case "Jack","Rose":
    print("Right person")
default:
    break
}

let character: Character = "a"
switch character {
case "a","A":
    print("the letter A")
default:
    print("Not the letter A")
}

// 区间匹配、元祖匹配
let count = 62
switch count {
case 0:
    print("none")
case 1..<5:
    print("a few")
case 5..<12:
    print("serveral")
case 12..<100:
    print("dozens of")
case 100..<1000:
print("hundreds of")    
default:
    print("many")
}


let point = (1,1)
switch point {
case (0,0):
    print("the origin")
case (_,0):
    print("on the x-axis")
case (0,_):
    print("on the y-axis")
case(-2...2,-2...2):
    print("inside the box")
default:
    print("outside of the box")
}
// 值绑定, 必要时let 可以改成var】
let point_1 = (2,0)
switch point {
case (let x,0):
    print("on the x-axis with an x value of \(x)")
case (0,let y):
    print("on the y-axis with a y value of \(y)")
case let (x,y):
    print("somewhere else at （\(x),\(y)）")    
}


// where
switch point {
case let (x,y) where x == y:
    print("on the line x == y")
case let (x,y) where x == -y:
    print("on the line x == -y")
case let (x,y):
    print("(\(x),\(y)) is just some arbitrary point")
}
// 讲所有整数加起来
var numbers = [10,20,-10,-20,30,-30]
var sum = 0
for num in numbers where num > 0 {
    sum += num
}
print(sum)

// 标签语句
outer:for i in 1...4 {
    for k in 1...4 {
        if k == 3 {
            continue outer 
        }
        if i == 3 {
            break outer
        }
        print("i==\(i),k==\(k)")
    }
}

