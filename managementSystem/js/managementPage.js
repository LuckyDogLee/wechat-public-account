/* 页面加载时，生成文章列表页面 */
window.onload = function(){
	/* 首页默认显示"法制快讯栏目的文章" */
	document.getElementById("topic1").className += " active";

	createArticleList(1);
}


/* 生成文章图文列表页面 */
function createArticleList(topicId)
{
	/* 文章图文列表模块 */
	var articleUl = document.createElement("ul");
	var str1 = "";
	for(var i = 1; i <= 15; i++){
		str1 += "<li class='articleBox' id='" + i + "' onclick='getArticleDetail(" + topicId +", " + i + ")'>"
		+"<img class='articleImg' src='../img/1.jpg'>"
		+"<div class='articleWord'>"
				+"<div class='articleTitle'>"
					+"我是topic " + topicId + " 第" + i + "篇文章的标题"
				+"</div>"
			+"</div>"
		+"</li>";
	}
	articleUl.innerHTML = str1;
	articleUl.id = 'articleUl';


	/* 底部分页导航栏 */
	var bottomBar = document.createElement("div");
	var str2
				="<div id='bottomNav'>"
				+ 	"<button id='newArticle' class='bottomNavItem' href='' onclick='newArticlePage()'>发布新文章</button>"
				+ 		"<a id='last' class='bottomNavItem' href=''>上一页</a>"
				+ 		"<a id='now' class='bottomNavItem'>1/5</a>"
				+		"<button id='next' class='bottomNavItem' href='' onclick='loadXMLDoc()'>下一页</button>"
				+ "</div>";

	bottomBar.innerHTML = str2;
	bottomBar.id = 'bottomBar';

	/* 将新创建的两个新节点添加到right元素中 */
	var right = document.getElementById("right");
	right.innerHTML = "";
	right.appendChild(articleUl);
	right.appendChild(bottomBar);
}


/* 修改被选中的navButton的背景颜色, 更换不同主题的文章图文列表 */
function changeTopic(topicId)
{
	for(var i=1; i <= 4; i++){
		document.getElementById("topic" + i).className = "nav";
	}
	document.getElementById("topic" + topicId).className += " active";
	createArticleList(topicId);
}


/* 生成发布新文章的页面 */
function newArticlePage()
{
	document.getElementById("right").innerHTML
	= "<div id='parent'>"
			+"<div id='child'>"
		+"<table>"
	+ "<tr><th colspan='2' align='center'>发布新文章</th></tr>"
		+ "<tr><td>文章标题</td><td><input id='title' type='text'/></td></tr>"
		+ "<tr><td>文章类型</td><td><input id='topic' type='text'/></td></tr>"
	+ "<tr><td>文章图片</td><td><input id='img' type='text'/></td></tr>"
	+ "<tr><td>文章概要</td><td><input type='text'/></td></tr>"
	+ "<tr><td>文章内容</td><td><textarea id='content' type='text'/></textarea></td></tr>"
	+ "<tr><td colspan='2' align='center'><input id='newArticleBtn' type='button' onclick='articleAdding()' value='发布' /></td></tr>"
	+ "</table>"
	+ "</div>"
	+ "</div>"
	;
}

/* 生成文章详情的页面 */
function getArticleDetail(topicId, id)
{
	document.getElementById("right").innerHTML
	= "<div id='parent'>"
			+"<div id='child'>"
		+"<table>"
	+ "<tr><div id='imgBtn'><img class='imgItem' src='../img/editor.png' onclick='editor()'>"
	+ "<img class='imgItem' src='../img/delete.png' onclick='deleteFun(" + topicId + ", " + id + ")'></div></tr>"
		+ "<tr><td>文章标题</td><td><input id='title' type='text'/></td></tr>"
		+ "<tr><td>文章类型</td><td><input id='topic' type='text'/></td></tr>"
	+ "<tr><td>文章图片</td><td><input id='img' type='text'/></td></tr>"
	+ "<tr><td>文章概要</td><td><input id='summary' type='text'/></td></tr>"
	+ "<tr><td>文章内容</td><td><textarea id='content' type='text'/></textarea></td></tr>"
	+ "</table>"
	+ "</div>"
	+ "</div>"
	;

	document.getElementsByTagName("input")[0].setAttribute("disabled", "");
	document.getElementsByTagName("input")[1].setAttribute("disabled", "");
	document.getElementsByTagName("input")[2].setAttribute("disabled", "");
	document.getElementsByTagName("input")[3].setAttribute("disabled", "");
	document.getElementsByTagName("textarea")[0].setAttribute("disabled", "");

	document.getElementById("title").value = "Topic " + topicId + " 第" + id + "篇文章的标题";
	document.getElementById("topic").value = "Topic " + topicId + " 第" + id + "篇文章的类型";
	document.getElementById("img").value = "Topic " + topicId + " 第" + id + "篇文章的图片";
	document.getElementById("summary").value = "Topic " + topicId + " 第" + id + "篇文章的概要";
	document.getElementById("content").value = "Topic " + topicId + " 第" + id + "篇文章的内容";
}

/* 文章详情页面编辑文章功能 */
function editor()
{
	document.getElementsByTagName("input")[0].disabled = false;
	document.getElementsByTagName("input")[1].disabled = false;
	document.getElementsByTagName("input")[2].disabled = false;
	document.getElementsByTagName("input")[3].disabled = false;
	document.getElementsByTagName("textarea")[0].disabled = false;

	var tableRow = document.getElementsByTagName("table")[0].insertRow(6);
	var flag = document.getElementById("saveBtn");
	if (flag == null) {
		tableRow.innerHTML = "<td colspan='2' align='center'><input id='saveBtn' type='button' onclick='articleModifying()' value='保存' /></td>"
	};
}

/* 文章详情页面删除文章功能 */
function deleteFun(topicId, id)
{
	/* Todo: 删除数据库中对应 id 的文章 */

	/* 返回(生成)相对应 topic 的文章列表页 */
	createArticleList(topicId);
}