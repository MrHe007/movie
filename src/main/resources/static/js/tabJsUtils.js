
// 传递 选择器路径，进行 table 监听
// element 表示 tab 对象
function tabListener(element, selector) {
// li.layui-nav-item dl dd a
    $(selector).click(function () {

        // 纯文字
        title1 = $(this).text();

        // 文字加图标
        title = $(this).html();
        console.log(title);
        path = $(this).attr("path");
        tabId = $(this).attr("tab-id");
        console.log(path + "  " + tabId);

        // 去除重复的tab
        for (var i = 0; i < $('.ok-frame').length; i++) {
            if (tabId == $('.ok-frame').eq(i).attr("tab-id")) {
                // 表示该选项卡已经 add 进 tab中了
                element.tabChange("my-tab", tabId);
                event.stopPropagation();
//				 console.log("stop append!");
                return;
            }

        }


        element.tabAdd('my-tab', {
            title: title,
            content: "<iframe src='" + path + "' tab-id='" + tabId + "' class='ok-frame' frameborder='0' scrolling='yes' width='100%' height='100%'></iframe>",
            id: tabId
        });

        // 切换选项卡
        element.tabChange("my-tab", tabId);
    });

}