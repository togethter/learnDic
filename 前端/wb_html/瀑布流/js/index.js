(function () {
    // 抽取的函数 === 比较，类型比较
    function $(id) {
        return typeof  id === 'string'? document.getElementById(id):id;
    };

window.onload = function () {
    // 1.1实现瀑布流布局
    waterFal('main','box');
    // 1.2监听滚动
    window.onscroll = function () {
    // 1.2.1 判断是否具备滚动加载的条件
    if (checkWillLoad()) { // bool

    // 1.3 本地数据
        var imgData = {"img":[{'icon':'1.jpg'},{'icon':'2.jpg'},{'icon':'3.jpg'},{'icon':'4.jpg'}]};
    // 1.4 遍历数据数组
    for (var i =0;i<imgData.img.length;i++){
        // 1.5创建最外面的盒子
        var newBox = document.createElement('div');
        newBox.className = 'box';
        $('main').appendChild(newBox);

        // 1.6 创建里面的盒子
        var newpic = document.createElement('div');
        newpic.className = 'pic';
        newBox.appendChild(newpic);
        // 1.7 创建图片标签
        var newimg = document.createElement('img');
        newimg.src = 'img/' + imgData.img[i].icon;
        newpic.appendChild(newimg);
    }

    waterFal('main','box');
    }
    }

};
    // 实现瀑布流布局
    function waterFal(parent,child) {
        /*----------------父标签居中------------------*/
        // 1.1拿到所有的字盒子
    var allBox = document.getElementsByClassName(child);
        // 1.2求出期中一个盒子的宽度
        var boxWidth = allBox[0].offsetWidth;
        // 1.3获取窗口的宽度
        var clientWidth = document.body.clientWidth;

        // 求出列数
        var cols = Math.floor(clientWidth / boxWidth);
        //1.5 让父标签居中
        $(parent).style.width = boxWidth * cols + 'px';
        $(parent).style.margin = '0 auto';
        /*----------------子盒子的定位------------------*/
        // 1.1告诉数组
        var  heightArr = [];
        // 1.2遍历所有的盒子数组
        for (var i = 0;i< allBox.length;i++) {
        //1.2.1取出每一个盒子
        var boxHeight = allBox[i].offsetHeight;
        //1.2.2判断
            if (i<cols){// 第一行的盒子
                heightArr.push(boxHeight);
            } else  {// 不是第一行的盒子
            //    1.2.3 从高度数组中取出最矮高度
                var minBoxHeight = Math.min.apply(null,heightArr);
            //    1.2.4 取出最矮盒子高度在数组中的索引
                var minBoxIndex = getMinBoxIndex(heightArr,minBoxHeight);
            //    1.2.5 子盒子定位 position top left
                allBox[i].style.position = 'absolute';
                allBox[i].style.top = minBoxHeight + 'px';
                allBox[i].style.left = minBoxIndex * boxWidth + 'px';
            //    1.2.6 更新高度数组中的最矮高度
                heightArr[minBoxIndex] += boxHeight;

            }
        }
        console.log(minBoxHeight);
    }

    // 取出最小的索引
    function getMinBoxIndex(arr,val) {
        for (var i in arr) {
            if (arr[i] == val) return i;
        }
    }

    // 判断是否具有滚动加载条件
    function checkWillLoad() {
    // 1、拿到最后的一个盒子
    var allBox = $('main').getElementsByClassName('box');
    var lastBox = allBox[allBox.length - 1];
    // 2、求出最后一个盒子高度的一半 + 头部偏离的位置
        var lastBoxDis = lastBox.offsetHeight * 0.5 + lastBox.offsetTop;
    // 3、求出页面的高度 --->兼容问题 混杂模式
        var clientHeight = document.body.clientHeight || document.documentElement.clientHeight;
    // 4、求出页面偏离浏览器的高度
        var scrollTopHeight = document.body.scrollTop || document.documentElement.scrollTop ;
        console.log(lastBoxDis,clientHeight +scrollTopHeight);
        return lastBoxDis <= clientHeight + scrollTopHeight;
    }
})();