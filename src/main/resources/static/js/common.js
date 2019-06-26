


layui.use('layer', function(){
    var layer = layui.layer;


    $("#logout").click(function () {

        layer.confirm("确认退出？",{icon: 3, title:'提示'}, function(index){
            // 确认退出
            layer.close(index);


            // 跳转到退出的方法
            location.href = "/user/logout";

        });



    });
});

// $(function () {
//
//     // $('input.keyword').bind('input propertychange',function() {
//     //     //进行相关操作
//     //
//     //     console.log("click");
//     //
//     // });
//
//     $("#searchBtn").click(function () {
//        console.log("search btn click");
//     });
//
//     var search_ipt = document.querySelector("#keyword");
//     var info = document.querySelector("#opt-list");
//
//     var input = $("#keyword");
//     var ul = $("#opt-list");
//     var tips_div = $("#tips_box");      // 存放 ul->li 的 div
//
//
//     search_ipt.oninput = function () {
//
//
//
//         let val = this.value; //传送到后端的关键字
//
//         console.log(val);
//
//         var url1 = 'localhost/movie/search.json?q=' + val;
//
//         // 设置count 表示请求的数量
//         var url = 'http://localhost/api/movie/search';
//         var url2 = 'http://localhost/movie/search.json?q=%E6%88%98%E7%8B%BC';
//
//
//         $("#opt-list").on("click", "li span", function (data) {
//
//             console.log("电影ID: " + $(this).attr("data-id"));
//
//             var movieId = $(this).attr("data-id");
//
//             // 跳转到指定的电影
//             var toUrl = "http://localhost/movie/subject/" + movieId;
//
//             location.href = toUrl;
//
//         });
//
//
//         $.ajax({
//
//             url: url,
//             data: {q: val},
//             success: function (data) {
//
//                 ul.empty();
//
//                 response = data.subjects;
//                 // console.log(response);
//                 // console.log(response);
//                 var arr = response;
//
//
//                 // 如果返回没有数据，则隐藏
//                 if(!arr){
//                     tips_div.css({display:"none"});
//                 }else{  // 有数据 , 将提示框显示
//                     tips_div.css({display:"block"});
//
//                     for(var i=0; i<arr.length; i++){
//
//                         var elem = arr[i];
//                         var listr = '<li><span data-id="'+ elem.id + '">' + elem.title + '</span></li>';
//
//                         ul.append(listr);
//                         // console.log(ul.html());
//
//                     }
//                 }
//
//             }
//
//         });
//
//
//     }
//
// });