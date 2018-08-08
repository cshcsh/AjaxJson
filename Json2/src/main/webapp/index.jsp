<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findInfo() {
		var xmlHttp;
		var title=document.getElementById("title").value;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

				alert(xmlHttp.responseText);
				var dataObj = eval("(" + xmlHttp.responseText + ")");
				var table = document.getElementById("table");
				var table2 = document.getElementById("table2");
				var newTr;
				var newTd1;
				var newTd2;
				
				var newTr2;
				var newTd21;
				var newTd22;
				
				
				document.getElementById("error_code").innerHTML=dataObj.error_code;
				document.getElementById("reason").innerHTML=dataObj.reason;
				document.getElementById("title2").innerHTML=dataObj.result.title;
				document.getElementById("tag").innerHTML=dataObj.result.tag;
				document.getElementById("act").innerHTML=dataObj.result.act;
				document.getElementById("year").innerHTML=dataObj.result.year;
				document.getElementById("rating").innerHTML=dataObj.result.rating;
				document.getElementById("area").innerHTML=dataObj.result.area;
				document.getElementById("dir").innerHTML=dataObj.result.dir;
				document.getElementById("desc").innerHTML=dataObj.result.desc;
				document.getElementById("cover").innerHTML="<img src='"+dataObj.result.cover+"'/>"+dataObj.result.cover;
				for(var i=0;i<dataObj.result.act_s.length;i++){
					var acts = dataObj.result.act_s[i];
					var newTr = table.insertRow();
					newTd1 = newTr.insertCell();
					newTd2 = newTr.insertCell();
					newTd1.innerHTML = acts.name;
					newTd2.innerHTML="<img src='"+acts.image+"'/>";
				}
				document.getElementById("vdo_status").innerHTML=dataObj.result.vdo_status;
				document.getElementById("playlinks").innerHTML=dataObj.result.playlinks.youku;
				for(var i=0;i<dataObj.result.video_rec.length;i++){
					var video_rec = dataObj.result.video_rec[i];
					var newTr2 = table2.insertRow();
					newTd21 = newTr2.insertCell();
					newTd22 = newTr2.insertCell();
					newTd21.innerHTML = video_rec.title;
					newTd22.innerHTML="<img src='"+video_rec.cover+"'/>";
				}

			}

		};
		xmlHttp.open("get", "getInfo?title="+title, true);
		xmlHttp.send();
	}
</script>
</head>
<body>
	<input type="text" id="title">
	<input type="button" value="搜索" onclick="findInfo()"><br>
	返回码:<span id="error_code"></span><br>
	返回说明:<span id="reason"></span><br>
	影视名称:<span id="title2"></span><br>
	影视类型:<span id="tag"></span><br>
	演员:<span id="act"></span><br>
	年代:<span id="year"></span><br>
	级别:<span id="rating"></span><br>
	地区:<span id="area"></span><br>
	导演:<span id="dir"></span><br>
	剧情:<span id="desc"></span><br>
	影视海报:<span id="cover"></span><br>
	演员海报:<table id="table"></table><%-- <span id="name${ }"></span><span id="image${ }"></span> --%><br>
	影视状态:<span id="vdo_status"></span><br>
	播放链接:<span id="playlinks"></span><br>
	视频相关:<table id="table2"></table><br>
</body>
</html>