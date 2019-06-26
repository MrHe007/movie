layui.use(['layer', 'form','element'], function(){
  var layer = layui.layer
  ,element = layui.element
  ,$ = layui.jquery
  ,form = layui.form;
	
	// 控制侧边的收缩状态
	$("#menu-switch").click(function(){
		console.log("menu-switch");
		// 下判断是否是靠左边
		// 正常状态
		if( $(".layui-layout-admin .layui-side").css("left") == '0px' ){
			
			$(".layui-layout-admin .layui-side").animate({left:-200});
			$(".layui-layout-admin .content-body").animate({left:0});
			$(".layui-layout-admin .layui-footer").animate({left:0});
			
		}else{
			$(".layui-layout-admin .layui-side").animate({left:0});
			$(".layui-layout-admin .content-body").animate({left:200});
			$(".layui-layout-admin .layui-footer").animate({left:200});
		}
	});
	
	// 监听退出按钮
	$("#logout").click(function(){
		
		layer.open({
			content: '您确定要退出吗？',
			btn: ['确认','退出'],
			yes: function(index,layero){
				// 点击按钮1的回调
				console.log("退出");
			},
			btn2: function(index,layero){
				// 点击安妮2的回调
				console.log("不退出");
			},
			anim: 6,
			skin: 'layui-layer-lan'
		});
		
	});
	
	
	

});