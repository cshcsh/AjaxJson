<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function loadInfo2() {
		var xmlHttp;
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
				alert(dataObj.students.length);
				var newTr;
				var newTd1;
				var newTd2;
				var newTd3;
				for (var i = 0; i < dataObj.students.length; i++) {
					var student = dataObj.students[i];
					var newTr = table.insertRow();
					newTd1 = newTr.insertCell();
					newTd2 = newTr.insertCell();
					newTd3 = newTr.insertCell();
					newTd1.innerHTML = student.name;
					newTd2.innerHTML = student.age;
					newTd3.innerHTML = "语文:" + student.score.chinese + "数学:"
							+ student.score.math + "英语:"
							+ student.score.english;
				}

			}

		};
		xmlHttp.open("get", "getInfo", true);
		xmlHttp.send();
	}
</script>
</head>
<body>
	<input type="button" onclick="loadInfo2()" value="提交">
	<table id="table">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>成绩</th>
		</tr>
	</table>
</body>
</html>