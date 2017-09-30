

$(document).ready(function(){
	add();
	$("#slelectall").click(function(){
		selectAll(this);
	});
	$("#delAllSeleted").click(function(){
		del(this);
	})
});

function add(){
	for(var i=1;i<=5;i++){
		$("#table").append(//动态添加行
			'<tr>' +
			'<td><input class="selectrow" type="checkbox"> </td>' +
			'<td>Tom'+i+'</td>' +
			'<td>2017-09-07</td>' +
			'<td>How are you?</td>' +
			'<td>delete target</td>' +
			'</tr>');
	}
}

function selectAll(that){
	if(that.checked){
		$("input[type=checkbox]").prop("checked", true);
	}else{
		$("input[type=checkbox]").prop("checked", false);
	}
}
function del(that){
	if(window.confirm('你确定要删除所有所选择的吗？')) {
		$("#table input[type=checkbox]:checked").each(function () {
			n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
			if(n!=0){
				$("#table").find("tr:eq(" + n + ")").remove();
			}


		});
	}
}
