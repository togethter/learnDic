(function () {
    // 页面加载完毕
    $(window).on('load', function () {
        // 1.实现瀑布流布局
        WaterFull();
        // 2.监听浏览器的滚动
        $(window).on('scroll', function () {
            if (checkWillLoad()) {
                // 数据
                var data = {"imgData": [{'icon': '1.jpg'}, {'icon': '2.jpg'}, {'icon': '3.jpg'}, {'icon': '4.jpg'}]};
                var imgDataArr = data.imgData;
                // 遍历加载
                $.each(imgDataArr,function (index,value) {
                // 创建标签
                    var newBox = $('<div>').addClass('box').appendTo($('#main'));
                    var newPic = $('<div>').addClass('pic').appendTo($(newBox));
                    $('<img>').attr('src','img/' + $(value).attr('icon')).appendTo($(newPic));
                });
                // 重新布局
                WaterFull();
            }
        });
    });

// 实现瀑布流布局
function WaterFull() {
//    ---------父标签-----------
// 父标签居中
// 1
    var allBox = $('#main .box');
// 2 width 不包括内边距 outerWidth 包括内边距和边框
    var boxWidth = $(allBox).eq(0).outerWidth();
// 3
    var clientWidth = $(window).width();
// 4
    var cols = Math.floor(clientWidth / boxWidth);
// 5.父标签居中 ------>css样式
    $('#main').css({
        width: cols * boxWidth + 'px',
        margin: '0 auto',
    });
//    ---------父标签-----------
//    ---------子盒子定位-----------

//    1.
    var heightArr = [];
//    2.遍历
    $.each(allBox,function (index,value) {
     //   2.1获取每一个盒子的高度
     var boxHeight = $(value).outerHeight();
     // 2.2 判断
     if (index < cols) { // 第一行
        heightArr[index] = boxHeight; // heightArr.push(boxHeight);
     } else  {
     // 2.3 剩余盒子的定位
         var minBoxHeight = Math.min.apply(null,heightArr);
         var minBoxIndex = $.inArray(minBoxHeight,heightArr);
     // 2.4 定位
         $(value).css({
        position:'absolute',
             top:minBoxHeight + 'px',
             left:minBoxIndex * boxWidth + 'px'
         });
     // 2.5更新高度
        heightArr[minBoxIndex] += boxHeight;
     }
    })
}

// 判断是否具有加载条件
    function checkWillLoad() {
    // 1.获取最后一个标签
        var lastBox = $('#main>div').last();
    // 2.求基于盒子的尺寸
        var  lastBoxDiss = $(lastBox).outerWidth() * 0.5 + $(lastBox).offset().top;
    // 3. 求出浏览器的高度
        var clientHeight =$(window).height();
    // 4.求出页面偏离浏览器的高度
        var scrollTopHeight = $(window).scrollTop();

        console.log(lastBox,clientHeight,scrollTopHeight);
    // 5.判断返回
        return lastBoxDiss <= clientHeight + scrollTopHeight;
    }


})();