function smallDog() {
// 属性
    this.name = null;
    this.age = null;
    // 方法
    this.eat = function (something) {
        console.log('狗名' + this.name + '年龄' + this.age + '正在吃' + something)
    }
}