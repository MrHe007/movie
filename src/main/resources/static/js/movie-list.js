

//一般直接写在一个js文件中
layui.use(['layer', 'form','laypage','element','flow'], function(){
    var layer = layui.layer,
        laypage = layui.laypage
        ,form = layui.form
        ,$ = layui.jquery
        ,flow = layui.flow
        ,element = layui.element;

    // 电影列表首页导航的全部数据
    var navDataUrl = 'http://localhost/movie/navdata.json';
    var movieListUrl = 'http://localhost/movie/list.json';


    // 定义懒加载方法
    function lazyLoad(obj) {

        flow.load({
            elem: 'dl.movie-list' //指定列表容器
            ,isAuto:false
            ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
                var lis = [];

                console.log(page);

                // 拿到nav数据
                var obj = getNavData();
                obj.start = (page-1)*20;


                // // 最后一个参数是为了中间传递参数

                $.get(movieListUrl,obj, function(data){

                    // 点击 /subject/{id}.json

                    for (index in data.data) {
                        var elem = data.data[index];
                        // debugger
                        var child = '<dd class="movie-item">\n' +
                            '\t\t\t\t\t<div class="movie-item-content">\n' +
                            '\t\t\t\t\t\t<div class="movie-img" style="text-align: center;">\n' +
                            '\t\t\t\t\t\t\t<a href="/movie/subject/'+elem.id+'" title="'+elem.title+'">\n' +
                            '\t\t\t\t\t\t\t\t<img src="' + elem.cover + '" alt="' + elem.title + '"/>\n' +
                            '\t\t\t\t\t\t\t</a>\n' +
                            '\t\t\t\t\t\t</div>\n' +
                            '\t\t\t\t\t\t<!--电影评分-->\n' +
                            '\t\t\t\t\t\t<div class="movie-score">\n' +
                            '\t\t\t\t\t\t\t<span >' + elem.rate + '</span>\n' +
                            '\t\t\t\t\t\t</div>\n' +
                            '\t\t\t\t\t\t<div class="movie-name">\n' +
                            '\t\t\t\t\t\t\t<h4 style="text-align: center;">\n' +
                            '\t\t\t\t\t\t\t\t<a href="#" style="font-weight: 700;">' + elem.title + '</a>\n' +
                            '\t\t\t\t\t\t\t</h4>\n' +
                            '\t\t\t\t\t\t</div>\n' +
                            '\t\t\t\t\t</div>\n' +
                            '\t\t\t\t</dd>\t\t';

                        // 把添加数据放到列表中
                        lis.push(child);
                    }
                    next(lis.join(''), page < 100);
                });

            }
        });


    }



    // 点击调整到电影详情页面
    $("dl.movie-list").on("click","dd.movie-item a",function () {
        // alert("demo");
        console.log($(this).attr("href"));


    });




    // 渲染头部
    // ajax 渲染全部形式
    $.get(navDataUrl,function (data) {

        // debugger
        var dataObj = data;

        // <li class="active"><span class="tag">剧情</span> </li>


        var typesArr = data.types;
        var genresArr = data.genres;
        var featuresArr = data.features;
        var yearsArr = data.years;
        var countriesArr = data.countries;


        // 插入类型
        for(var i=0; i<typesArr.length; i++){
            var insertStr = null;
            if(i==0){
                insertStr = '<li class="active"><span class="tag">'+typesArr[i]+'</span> </li>';
                // insertStr = '<li class="active"><span class="tag">'+typesArr[i]+'</span> </li>';
            }else{
                insertStr = '<li ><span class="tag">'+typesArr[i]+'</span> </li>';
            }

            $("ul.types").append(insertStr);
        }

        // 插入类别
        for(var i=0; i<genresArr.length; i++){
            var insertStr = null;
            if(i==0){
                insertStr = '<li ><span class="tag">'+genresArr[i]+'</span> </li>';
            }else{
                insertStr = '<li ><span class="tag">'+genresArr[i]+'</span> </li>';
            }

            $("ul.genres").append(insertStr);
        }


        // 插入年代
        for(var i=yearsArr.length-1; i>=0; i--){
            var insertStr = null;
            if(i==0){
                insertStr = '<li ><span class="tag">'+yearsArr[i]+'</span></li>';
            }else{
                insertStr = '<li ><span class="tag">'+yearsArr[i]+'</span></li>';
            }

            $("ul.years").append(insertStr);
        }

        // 插入特色
        for(var i=0; i<featuresArr.length; i++){
            var insertStr = null;
            if(i==0){
                insertStr = '<li ><span class="tag">'+featuresArr[i]+'</span> </li>';
            }else{
                insertStr = '<li ><span class="tag">'+featuresArr[i]+'</span> </li>';
            }

            $("ul.features").append(insertStr);
        }

        // 插入地区

        for(var i=0; i<countriesArr.length; i++){
            var insertStr = null;
            if(i==0){
                insertStr = '<li ><span class="tag">'+countriesArr[i]+'</span> </li>';
            }else{
                insertStr = '<li ><span class="tag">'+countriesArr[i]+'</span> </li>';
            }

            $("ul.countries").append(insertStr);
        }

    });


    $("ul").on("click", "li",function () {

        // 在当前点击的标签加入active
        // 在其兄弟节点的li去掉 active

        // 如果此时没有active，则加上，并将兄弟active去掉
        // 否则去掉active

        if( $(this).hasClass("active")){
            $(this).removeClass("active")

        }else{
            $(this).addClass("active" ).siblings().removeClass("active");
        };

        // 获取所有的 ul>li 下的 active 的内容
        // console.log( $("ul.category li.active"));


        var obj = getNavData();

        // 先清空原来的数据，后再懒加载
        $("dl.movie-list").empty();
        console.log(obj);
        // console.log(JSON.stringify(obj));

        // var objStr = JSON.stringify(obj);

        // 通过
        // renderMovieListByAjax(movieListUrl,obj,null);

        // 流式懒加载
        // movie-list
        lazyLoad(obj);


    });


    // 流式懒加载
    // movie-list

    var obj = getNavData();

    lazyLoad(obj);

    // 点击 近期热门 / 即将上映 / 评分最高按钮 只需要去掉或者加上  layui-btn-primary 类
    form.on('submit(submitBtn)', function(data){

        console.log(data);
        layer.msg(JSON.stringify(data.field));

        // 表示表单不提交
        return false;

    });
});