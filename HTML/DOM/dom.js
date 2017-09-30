
function addYear(){
	
	var sel1=document.getElementById("year");
	for(var i=2017;i>=0;i--){
		var op=document.createElement("option");
		op.innerHTML=i;
		sel1.appendChild(op);
	}
}
function addMonth(){
	var sel2=document.getElementById("month");
	for(var i=1;i<13;i++){
		var op=document.createElement("option");
		op.innerHTML=i;
		sel2.appendChild(op);
	}
}
function addDay(){
	var sel3=document.getElementById("day");
	for(var i=1;i<32;i++){
		var op=document.createElement("option");
		op.innerHTML=i;
		sel3.appendChild(op);
	}
}
function loadView(){
	addYear();
	addMonth();
	addDay();
}

function newData(){
	var sel3=document.getElementById("day");
	while (sel3.length>0){
		sel3.removeChild(sel3.childNodes[0]);
	}

	addDay();

}
function change(){

	newData();

	var sel1=document.getElementById("year");
	var sel2=document.getElementById("month");
	var sel3=document.getElementById("day");
	
	var yeardata=2017-sel1.selectedIndex;

	if(sel2.selectedIndex==3&&sel2.selectedIndex==5&&sel2.selectedIndex==8&&sel2.selectedIndex==10){
		alert("month is "+sel2);
		sel3.removeChild(sel3.childNodes[30]);
	}
	else if(sel2.selectedIndex==1){
		if(yeardata%4==0&&yeardata%100!=0||yeardata%400==0){

			sel3.removeChild(sel3.childNodes[29]);
			alert(sel3.length)
			sel3.removeChild(sel3.childNodes[29]);
			alert(sel3.length)
		}
		else{

			sel3.removeChild(sel3.childNodes[28]);
			sel3.removeChild(sel3.childNodes[28]);
			sel3.removeChild(sel3.childNodes[28]);
		}
	}

}