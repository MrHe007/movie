

layui.use(['layer', 'form','laypage','element','flow'], function() {
    var layer = layui.layer,
        laypage = layui.laypage
        , form = layui.form
        , $ = layui.jquery
        , flow = layui.flow
        , element = layui.element;

    // 这里定义需要有layui 的模板方法


    // alert("dmeo");




});

// 公共的Js

function test() {
    alert("demo");
}

// 请求头部的信息
function getNavData() {

    var types = $("ul.types>li.active").text();
    var genres = $("ul.genres>li.active").text();
    var countries = $("ul.countries>li.active").text();
    var years = $("ul.years>li.active").text();
    var features = $("ul.features>li.active").text();

    // 表示页数
    // var page = $("dl.movie-list span.hidden").val();

    // console.log(types);
    // console.log(genres);
    // console.log(countries);

    // console.log(years);
    // console.log(features);
    //  debugger

    // 按照years 字符串的长度区分

    if(years.length>0){
        if(years.length==2){
            // 更早
            years = new Array(1,1959);
        }else if(years.length==4 && years.indexOf("年代")>-1){
            // 60年代 -- 50年代
            years = years.substr(0,years.length-2);

            years = new Number(years);
            years = 1900 + years;
            years = new Array(years,years+9);

        }else if(years.length==4){
            // 2019 - 2018
            years = new Array(years,years);
        }else {
            // 2000年代
            console.log(years);
            console.log((years.length));
            years = years.substr(0,years.length-2);
            years = new Number(years);

            years = new Array(years.valueOf(),years+9);
        }

    }

    console.log(years);




    // 构造请求参数

    var obj = {
        "sort":"U",
        "start":0,
        "tags":types
    };

    // 构造请求参数

    if(genres.length>0){
        obj['genres'] = genres;
    }
    if(countries.length>0){
        obj['countries'] = countries;
    }
    if(years.length>0){
        // obj['year_range'] = years;
        obj.startYear = years[0];
        obj.endYear = years[1];
    }
    if(features.length>0){
        obj.features = features;
    }
    return obj;

}


// function lazyLoad(obj) {
//
//     flow.load({
//         elem: 'dl.movie-list' //指定列表容器
//         ,isAuto:false
//         ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
//             var lis = [];
//
//             console.log(page);
//
//             // 拿到nav数据
//             var obj = getNavData();
//             obj.start = (page-1)*20;
//
//
//             // // 最后一个参数是为了中间传递参数
//
//             $.get(movieListUrl,obj, function(data){
//
//                 for (index in data.data) {
//                     var elem = data.data[index];
//                     // debugger
//                     var child = '<dd class="movie-item">\n' +
//                         '\t\t\t\t\t<div class="movie-item-content">\n' +
//                         '\t\t\t\t\t\t<div class="movie-img" style="text-align: center;">\n' +
//                         '\t\t\t\t\t\t\t<a href="#" title="海王">\n' +
//                         '\t\t\t\t\t\t\t\t<img src="' + elem.cover + '" alt="' + elem.title + '"/>\n' +
//                         '\t\t\t\t\t\t\t</a>\n' +
//                         '\t\t\t\t\t\t</div>\n' +
//                         '\t\t\t\t\t\t<!--电影评分-->\n' +
//                         '\t\t\t\t\t\t<div class="movie-score">\n' +
//                         '\t\t\t\t\t\t\t<span >' + elem.rate + '</span>\n' +
//                         '\t\t\t\t\t\t</div>\n' +
//                         '\t\t\t\t\t\t<div class="movie-name">\n' +
//                         '\t\t\t\t\t\t\t<h3 style="text-align: center;">\n' +
//                         '\t\t\t\t\t\t\t\t<a href="#" style="font-weight: 700;">' + elem.title + '</a>\n' +
//                         '\t\t\t\t\t\t\t</h3>\n' +
//                         '\t\t\t\t\t\t</div>\n' +
//                         '\t\t\t\t\t</div>\n' +
//                         '\t\t\t\t</dd>\t\t';
//
//                     // 把添加数据放到列表中
//                     lis.push(child);
//                 }
//                 next(lis.join(''), page < 100);
//             });
//
//         }
//     });
//
//
// }

// 通过 ajax 渲染 movie-list
// 第三个参数用于中间传递参数
function renderMovieListByAjax(url,data,param) {

    $.ajax({
        type:'get',
        url:url,
        data:data,
        success:function (data) {
            console.log(data);

            // 先将电影列表置空
            $("dl.movie-list").empty();

            var movieList = $("dl.movie-list");

            for (index in data.data){
                var elem = data.data[index];
                // debugger
                var child = '<dd class="movie-item">\n' +
                    '\t\t\t\t\t<div class="movie-item-content">\n' +
                    '\t\t\t\t\t\t<div class="movie-img" style="text-align: center;">\n' +
                    '\t\t\t\t\t\t\t<a href="#" title="海王">\n' +
                    '\t\t\t\t\t\t\t\t<img src="'+ elem.cover +'" alt="'+elem.title+'"/>\n' +
                    '\t\t\t\t\t\t\t</a>\n' +
                    '\t\t\t\t\t\t</div>\n' +
                    '\t\t\t\t\t\t<!--电影评分-->\n' +
                    '\t\t\t\t\t\t<div class="movie-score">\n' +
                    '\t\t\t\t\t\t\t<span >'+ elem.rate +'</span>\n' +
                    '\t\t\t\t\t\t</div>\n' +
                    '\t\t\t\t\t\t<div class="movie-name">\n' +
                    '\t\t\t\t\t\t\t<h3 style="text-align: center;">\n' +
                    '\t\t\t\t\t\t\t\t<a href="#" style="font-weight: 700;">'+ elem.title +'</a>\n' +
                    '\t\t\t\t\t\t\t</h3>\n' +
                    '\t\t\t\t\t\t</div>\n' +
                    '\t\t\t\t\t</div>\n' +
                    '\t\t\t\t</dd>\t\t';


                movieList.append(child);

            }

            console.log(data);

        }
    });



}