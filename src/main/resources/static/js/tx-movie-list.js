function getParams(obj){
    console.log("getParams")
    // debugger
    // / 每次点击tag 都拿到全部的tag数据，发送ajax
    let header = obj.headerData;
    let sortDataUrl = header.sortType[obj.position.sortIndex-1];
    let areatDataUrl = header.areas[obj.position.areaIndex-1];
    let featuresDataUrl = header.features[obj.position.featureIndex-1];
    let chargeDataUrl = header.charge[obj.position.chargeIndex-1];
    let yearsDataUrl = header.years[obj.position.yearIndex-1];

    // 提取出里面的字符串

    let sort_keyVal = sortDataUrl.url.substring(sortDataUrl.url.indexOf("?")+1).split("="); // sort=1
    let area_keyVal = areatDataUrl.url.substring(areatDataUrl.url.indexOf("?")+1).split("=");
    let features_keyVal = featuresDataUrl.url.substring(featuresDataUrl.url.indexOf("?")+1).split("=");
    let charge_keyval = chargeDataUrl.url.substring(chargeDataUrl.url.indexOf("?")+1).split("=");
    let years_keyVal = yearsDataUrl.url.substring(yearsDataUrl.url.indexOf("?")+1).split("=");
    // debugger

    // let params =new Map();

    // // var key = sort_keyVal[0]
    // // var val = sort_keyVal[1]
    // // params.key = val;

    // params.set(sort_keyVal[0],sort_keyVal[1]);
    // params.set(area_keyVal[0],area_keyVal[1]);
    // params.set(features_keyVal[0],features_keyVal[1]);
    // params.set(charge_keyval[0],charge_keyval[1]);
    // params.set(years_keyVal[0],years_keyVal[1]);
    // params.set("page",1);

    // params.

    let params = {};

    params.sort = sort_keyVal[1];
    params.iarea = area_keyVal[1];
    params.characteristic = features_keyVal[1];
    params.year = years_keyVal[1];
    params.charge = charge_keyval[1];
    params.page = 1;

    return params;


    // 清空下方电影数据
    // vm.movieList = [];
}