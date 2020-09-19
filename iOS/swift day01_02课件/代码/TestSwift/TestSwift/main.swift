//
//  main.swift
//  TestSwift
//
//  Created by MJ Lee on 2019/6/16.
//  Copyright © 2019 MJ Lee. All rights reserved.
//

//var a = 10
//a = 20
//a = 30
//
//let b = 10

//print(a)
//print(b)
// print("Hello World! - \(a)")

//print("Hello, World!")
//print("test")

//var numbers = [10, 20, 30]
//numbers[0] = 20
//numbers[0] = 30
//
//
//func test(_ num: inout Int) {
//
//}
//
//test(&numbers[0])

/*
 var number = 10
 
 func test(_ num: Int) {
 
 }
 
 test(number)
 
 0x100000f5e <+78>: movq   -0x30(%rbp), %rdi
 0x100000f62 <+82>: callq  0x100000f70               ; TestSwift.test(Swift.Int) -> () at main.swift:24
 
 var number = 10
 
 func test(_ num: inout Int) {
 
 }
 
 test(&number)
 
 0x100000f47 <+55>: leaq   0x10ca(%rip), %rdi        ; TestSwift.number : Swift.Int
 0x100000f4e <+62>: callq  0x100000f70               ; TestSwift.test(inout Swift.Int) -> () at main.swift:24
 */

var number = 10
func test(_ num: inout Int) {
  num = 20
}
test(&number)

class Person {
    var test: Int = 0
    var age: Int {
        get {
            print("get")
            return 10
        }
        set {
            print("set\(newValue)")
        }
    }
}

var p = Person()
test(&p.age)

