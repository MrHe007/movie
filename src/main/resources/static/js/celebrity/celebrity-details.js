  //一般直接写在一个js文件中
  layui.use(['layer', 'form', 'element', 'rate', 'flow'], function () {
    var layer = layui.layer
        , element = layui.element
        , rate = layui.rate
        , $ = layui.jquery
        , flow = layui.flow
        , form = layui.form;


    // 监听两个“全部”按钮
    // 监听跳到演职人员panel
    $("#toCelebrityPanelBtn").click(function () {

        element.tabChange('demo', '22');

        console.log("toCelebrityPanelBtn");
    });

    // 监听跳到图集的 panel
    $("#toPhotosPanel").click(function () {
        element.tabChange('demo', '33');
        // console.log("toPhotosPanel");
    });


    // 点击评论按钮
    $("#comment").click(function () {

        layer.open({
            title: "评论",
            type: 2,
            content: ['http://localhost/page/page/comment.html', 'no'],
            area: ['550px', '480px']

        });

        // var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        // console.log("iframe index -> "+index)
        // parent.layer.close(index); //再执行关闭

    });


    var start = 1;
    var count = 12;

    // // 相册定义为懒加载
    // flow.load({
    //     elem: '#photo-list' //指定列表容器
    //     , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
    //         var lis = [];

    //         count = start + 12;


    //         //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
    //         $.get(photosUrl + "?start=" + start + "&count=" + count, function (data) {

    //             start = count;

    //             var res = data;
    //             // console.log(res);

    //             //假设你的列表返回在data集合中
    //             layui.each(res.photos, function (index, item) {

    //                 // 定义小图片
    //                 // var child = '<li><img src="'+item.icon+'" width="115px" height="115px"  /> </li>';
    //                 var child = '<li><img src="' + item.icon + '" /> </li>';

    //                 lis.push(child);
    //             });

    //             //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
    //             //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
    //             next(lis.join(''), page < res.total / 12 + 1);
    //         },'json');

    //         console.log(lis);

    //         $("ul.photo-list").append(lis);

    //     }
    // });



    // //相册渲染
    // layer.photos({
    //     photos: '#photos'
    //     , anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
    // });

    // //监听写短评按钮
    // $('#writeComment').click(function () {

    //     // 判断用户是否登入，如果登入写短评，否则先登入
    //     layer.msg("写短评");

    // });


    // // 渲染评论列表的星星
    // // comment_list_item_score_1
    // var res = rate.render({
    //     elem: '#movie-comment-score',
    //     value: 5,
    //     readonly: true
    // });


    // 评分
// var ins1 = rate.render({
//     elem: '#movie-score'  //绑定元素
//     , value: [[${ movie.rating.average }]] / 10 * 5
//     , half: true
//     , readonly: true
// });


    element.on('tab(demo)', function (data) {
        // console.log(data);
        // console.log(this);
        //	    console.log($(this).text());
        //	    console.log(data.index);
        //	    console.log(data.elem);
    });



    // 评价完后回调函数，弹出窗口
    var comment_score = rate.render({
        elem: '#movie-comment-score',

    });

});
