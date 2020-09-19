window.onload = function () {
    // 1.1获取需要的标签
    var list     = document.getElementById('tab_header').getElementsByTagName('li');
    var contents = document.getElementById('tab_content').getElementsByClassName('dom');
    console.log(contents);
    // 2.遍历
    for (var i = 0;i<list.length;i++) {
        // 1.2.1 取出单个对象
        var li = list[i];
        li.id = i;
        // 1.2.2 监听鼠标移动事件
        li.onmousemove = function () {
            // 让所有的li的class都清除
            for (var j = 0;j < list.length;j++){
                list[j].className = '';
                contents[j].style.display = 'none';

            }
        // 设置当前li的class
            this.className = 'selected';
            // 从contents数组中取出对应的标签
            contents[this.id].style.display = 'block';
        }
    }

}