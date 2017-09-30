var allPrice=0;
//修改购物车数量
function numchange(){
	$("#num").text($("#shoppinglist tr:gt(0)").length);
	if($("#shoppinglist tr:gt(0)").length!=0){
		$("#empty").hide();
	}else{
		$("#empty").show();
	}
}
//加入购物车
function add(that){

	$("#shoppinglist").append("" +
		"<tr align='center'>" +
			"<td><input type='checkbox' class='check'/></td>" +
			"<td>"+$(that).parent().find(".name").eq(0).text()+"</td>" +
			"<td>"+$(that).parent().find(".price").eq(0).text()+"</td>" +
			"<td><input type='button' value='删除' class='del' onclick='deleterow(this)'/></td>"+
		"</tr>");

	numchange();
	alert("加入购物车成功！");
}
//显示购物车页面
function showcart(){
	$("#list").hide();
	$("#cart").show();
}
//显示菜单页面
function showlist(){
	$("#list").show();
	$("#cart").hide();
}

//删除操作
function deleterow(that){
	var res=confirm("确定要删除么？");
	if(res){
		n = $(that).parents("tr").index();  // 获取checkbox所在行的顺序
		var price=$("#shoppinglist").find("tr:eq("+n+")").find("td:eq(2)").text();
		if($("#shoppinglist").find("tr:eq("+n+")").find("input").is(":checked")){//判断所删除行是否选中
			allPrice-=parseFloat(price);
		}
		$(that).parent().parent().remove();
		numchange();
		setTimeout("alert('删除成功');",500)
	}
	$("#allPrice").text(allPrice);//设置总金额
}
//全选操作
function selectall(){
	if($("#selectall").attr("checked")){
		allPrice=0;
		$(".check").each(function(){
			$(this).attr("checked","true");
			n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
			var price=$("#shoppinglist").find("tr:eq("+n+")").find("td:eq(2)").text();
			allPrice+=parseFloat(price);
		});
	}else{
		allPrice=0;
		$("input[type=checkbox]").prop("checked", false);
	}
	$("#allPrice").text(allPrice);//设置总金额

}
//删除所有选中操作
function deleteall(){
	var res=confirm("是否要删除所有选中的项？");
	if(res){
		$("#shoppinglist input[type=checkbox]:checked").each(function (){
			n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
			var price=$("#shoppinglist").find("tr:eq("+n+")").find("td:eq(2)").text();
			if($("#shoppinglist").find("tr:eq("+n+")").find("input").is(":checked")){//判断所删除行是否选中
				allPrice-=parseFloat(price);
			}
			$(this).parent().parent().remove();

		});
		numchange();
		setTimeout("alert('删除成功');",500)
	}
	$("#allPrice").text(allPrice);//设置总金额
}

/**
 *  单选操作
 */
function singleChoos(that){
	n = $(that).parents("tr").index();
	var price=$("#shoppinglist").find("tr:eq("+n+")").find("td:eq(2)").text();
	if(that.checked){
		allPrice+=parseFloat(price);
	}else{
		$("#selectall").prop("checked", false);
		allPrice-=parseFloat(price);
	}
	$("#allPrice").text(allPrice);//设置总金额
}

//添加事件，在加载前执行
$(function(){

	/**
	 * 点击每行前面的checkBox触发事件
	 */
	$(".check").live('click',function(){
		singleChoos(this);
	});
	/**
	 * 加入购物车事件
	 */
	$(".add").bind('click',function(){
		add(this);
	});
	/**
	 * 显示购物车事件
	 */
	$("#font").bind('click',function(){
		showcart();
	});
	/**
	 * 显示主页面操作
	 */
	$("#order").bind('click',function(){
		showlist();
	});
	/**
	 * 点击删除选中
	 */
	$("#delAllSeleted").bind('click',function(){
		deleteall();
	});
	/**
	 * 点击结算操作事件
	 */
	$("#pay").bind('click',function(){
		alert("总共付款"+allPrice+"元")
	});



});