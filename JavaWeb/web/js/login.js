/* 验证用户账号信息，若正确，则进入管理系统，若错误，输入边框和字体变红色 */
function msg()
{
  	var username, password, flag;
  	username = document.getElementById("username").value;
  	password = document.getElementById("password").value;
	flag = false;

	var xmlhttp;

	if (window.XMLHttpRequest){
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else{
		// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			flag = xmlhttp.responseText;

			/* 将字符串类型的 flag 转化为布尔类型 */
			if(flag == 'true'){
				flag = true;
			}else{
				flag = false;
			}

			if (flag) {
				//window.location.href = "html/managementPage.html?backurl=" + window.location.href;
				window.location.href = "html/managementPage.html";
			}else{
				document.getElementById("username").className += ' invalid';
				document.getElementById("password").className += ' invalid';
			}
		}
	}

	xmlhttp.open("POST","article/login",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("userName=" + username +"&userPassword=" + password);
}

/* 当鼠标聚焦到输入框时，恢复输入框的边框颜色 */
function stycleChange()
{
	document.getElementById("username").className = 'inputText';
  	document.getElementById("password").className = 'inputText';
}