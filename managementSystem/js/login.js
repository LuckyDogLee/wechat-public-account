/* 验证用户账号信息，若正确，则进入管理系统，若错误，输入边框和字体变红色 */
function msg()
{
  	var username, password;
  	username = document.getElementById("username").value;
  	password = document.getElementById("password").value;

  	if (username=="admin" && password=="123456") {
  		window.location.href = "managementPage.html?backurl=" + window.location.href;
  	}else{
  		document.getElementById("username").className += ' invalid';
  		document.getElementById("password").className += ' invalid';
  	}
}

/* 当鼠标移动到"退出"按钮时，改变该按钮的背景色 */
function stycleChange()
{
	document.getElementById("username").className = 'inputText';
  	document.getElementById("password").className = 'inputText';
}