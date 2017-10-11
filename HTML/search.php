<?php
		$message=$_GET['cd-textarea'];
		$time=date('Y-m-d H:i:s',time());
		$ip = $_SERVER["REMOTE_ADDR"];
		mysql_connect('localhost','root','JhFnZv9TmHhJ');
		//mysql_connect('localhost','root','root');
		mysql_select_db('data');
		mysql_query('set names utf8');
		$sql ="insert into express values(null,'$message','$ip','$time')";
		
		mysql_query($sql);
		$place=turn($message);
		openurl($place);
		echo $place;

function openurl($place)
{
	if($place==1){
		$url="http://a3.rabbitpre.com/m/VBjM3aw";
	 	//echo "医科大学老小吃街学苑驾校菜鸟驿站";
	}
	else if($place==2||$place==3){
		$url="http://a1.rabbitpre.com/m/77v2An0";
		//echo "温医生活区11号楼地下室徐氏驾校菜鸟驿站";//2
	}
	else if($place==4||$place==31){
		$url="http://a2.rabbitpre.com/m/JZNFVrI";
		//echo "温医南柳大榕树徐氏驾校菜鸟驿站";//4
	}
	else if($place==5||$place==6){
		//echo "温州大学E区2号楼";//5
		$url = "http://a2.rabbitpre.com/m/myuyMfj";
	}
	
	else if($place==7||$place==11||$place==28||$place==29||$place==33){
		$url="http://a1.rabbitpre.com/m/IZRuqERef";
		//echo "老小吃街圆通向前30米处中通快递";//7
	}
	//else if($place==8)
		//echo "温大C区10号楼楼下102室";//8
	else if($place==9){
		$url="http://a1.rabbitpre.com/m/VBjM3aw";
		//echo "温医南柳小吃街右拐荣兴超市";//9
	}
	else if($place==10||$place==32){
		$url ="http://a1.rabbitpre.com/m/3Qj6jaf";
		//echo "温职生活区内100米的快递中心";//10
	}

	else if($place==12){
		$url = "http://a1.rabbitpre.com/m/ZzqiquU";  
		//echo "温医小吃街左边右拐大榕树旁";//12
	}
	else if($place==13){
		$url="http://a1.rabbitpre.com/m/VBjM3aw";
		//echo "温医南柳小吃街荣兴超市对面驾校";//13
	}
	else if($place==14){
		$url="http://a3.rabbitpre.com/m/zi2UJvd";
		//echo "F区出来右手";//14
	}
	else if($place==15){
		$url="http://a2.rabbitpre.com/m/YVVrIzO";
	  // echo "温大A区13";//15
	}
	else if($place==16){
		$url="http://a3.rabbitpre.com/m/mrEBmrUJT";
		//	echo "温州商学院大门正对面优速快递";//16
	}
	else if($place==17){
		$url="http://a2.rabbitpre.com/m/3Qj6jaf";
		//echo "温职院生活区内快递中心菜鸟驿站";//17
	}
	else if($place==18){
		//echo "D区对面";
		$url="http://a2.rabbitpre.com/m/EfEZZBIZC";
	}
	else if($place==19||$place==24){
		//echo "北校对面";
		$url="http://a3.rabbitpre.com/m/NNzYJvD";	
	}
	else if($place==20){
		//echo "温州商学院F区2号楼";
		$url="http://a2.rabbitpre.com/m/FZZRY3jVB";	
	}
	else if($place==21){
		//echo "南门对面小兔子";
		$url="http://a1.rabbitpre.com/m/mFZZJ3bag";	
	}
	else if($place==22||$place==30){
		//echo "法特希";
		$url="http://a1.rabbitpre.com/m/QAA2bMIJH";	
	}
	else if($place==23){
		//echo "二食堂榕园后面";
		$url="http://a3.rabbitpre.com/m/eMIBmbaUH";	
	}
	
	else if($place==25||$place==26||$place==27){
		//echo "温大C区递易站点";
		$url="http://a3.rabbitpre.com/m/R7rUry0";	
	}else if($place==35){
		$url="http://a3.rabbitpre.com/m/Mb6ne21";
		}
	else if($place==36){
		$url="http://a3.rabbitpre.com/m/6biYbyj";
		}
	else if($place==34){
		echo "<p style="."font-size:85px".">Your express delivery, has not been signed by the agent, please wait ,it's not too long.</h1><br>";
	   return 0;
	}
	else
	{

	   echo "<p style="."font-size:50px".">This place maybe we not yet made it to use.<br>Or this isn't a place for express.<br>But don't worry.<br><a style="."font-size:60"." href="."http://wpa.qq.com/msgrd?v=1&uin=617669559".">Click thiere to jump to QQ ask me.</a><br>paste your information to it, and he will tell you what's the meaning of message.<br>If you don't have a account of QQ,just add my WeChat number of<p style="." color:red;font-size:60px".">julis617669559</p> </h1><br>";
	   	
		   return 0;
	}
	
	echo "<script type='text/javascript'>";  
	echo "window.location.href='$url'";  
	echo "</script>";  
}

function turn($message)
{
	$cont=0;
	$places=array(
	"医科大学老小吃街学苑驾校菜鸟驿站",//1
	"温医生活区11号楼地下室徐氏驾校菜鸟驿站",//2
	"温医生活区11号楼地下室",//3
	"温医南柳大榕树徐氏驾校菜鸟驿站",//4
	"温州大学E区2号楼",//5
	"E区2号楼",//6
	"老小吃街圆通向前30米处中通快递",//7
	"温大C区10号楼",//8
	"温医南柳小吃街右拐荣兴超市",//9
	"温职生活区内100米的快递中心",//10
	"温医小吃街圆通向前30米",//11
	"温医小吃街左边右拐大榕树旁",//12
	"温医南柳小吃街荣兴超市对面",//13
	"F区出来右手",//14
	"温大A区13号楼",//15
	"温州商学院大门正对面",//16
	"温职院生活区内快递中心菜鸟驿站",//17
	"D区大门口",//18
	"北校对面",//19
	"F区2号楼",//20
	"南门对面小兔子",//21
	"法特希",//22
	"二食堂",//23
	"温州大学北校区",//24
	"温大C区递易站点",//25
	"温大C区10号楼",//26
	"温州大学城C区递易智能",//27
	"老小吃街圆通往前走30米",//28
	"温医南柳路大榕树",//29
	"商学院大门对面",//30
	"温医小吃街大榕树",//31
	"温职",//32
	"老小吃街圆通向前30米",//33
	"派送中",//34
	"test");//3
	
	$number=count($places);
	
	foreach ($places as &$i) 
	{
   
		$cnt++;
		$p=strpos($message,$i);
		if($p!==false)
		{
			return $cnt;
			break;
		}
	}
	
	

}

  
?>	
