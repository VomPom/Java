
function addYear(){
	for(var i=2017;i>=0;i--){
		$("#year").append("<option>"+i+"</option>");
	}
}
function addMonth(){
	for(var i=1;i<13;i++){
		$("#month").append("<option>"+i+"</option>");
	}
}
function addDay(){
	for(var i=1;i<32;i++){
		$("#day").append("<option>"+i+"</option>");
	}
}
function newData(){
	while ($("#day option").length>0){
		$("#day option:eq(0)").remove();
	}
	addDay();
}

function change(){
	newData();
	var yeardata=($("#year option:selected").text());
	var monthdata=$("#month option:selected").text();

	if(monthdata==4||monthdata==6||monthdata==9||monthdata==12){
		$("#day option:eq(30)").remove();
	}
	else if(monthdata==2){
		if((yeardata%4==0&&yeardata%100!=0)||yeardata%400==0){
			$("#day option:eq(29)").remove();
			$("#day option:eq(29)").remove();

		}
		else{
			$("#day option:eq(28)").remove();
			$("#day option:eq(28)").remove();
			$("#day option:eq(28)").remove();

		}
	}

}
$(document).ready(function(){
	addYear();
	addMonth();
	addDay();
	$("#month,#day").click(function(){
		change();
	});
});



