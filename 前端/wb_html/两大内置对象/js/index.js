// DOM操作增删改查
// 1.c
//1.C
//1.1 直接写入body
document.write('<input type="button" value="按钮">');
//1.2 直接写入到对应的标签
// 获取到对应的标签
var test1       = document.getElementById('test1');
var fengJing    = document.createElement('img');
fengJing.src    = 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1585623299&di=b05a7a873dadc2fd568f8340e1562490&src=http://www.jinmen.cc/data/attachment/forum/201410/26/124432kjqjnryjtvnzj6ia.jpg';
// fengJing.style.overflow = 'auto';
fengJing.style.width = '100%';
test1.appendChild(fengJing);

// 2.R
document.getElementsByTagName('input')[0].remove();

// 3.改


//4.查
//4.1 getElement(s) By id,className,tagName,name

//4.2 直接打印
// console.log(test1.children);
console.log(test1.childNodes);
