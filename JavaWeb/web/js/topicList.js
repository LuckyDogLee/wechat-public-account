/**
 * Created by Jack Lee on 2015/12/15.
 */

var counter = 0;
var recordNum = 5;
var topic = 0;
var num = 0;

/* 全局变量: 储存文章信息的 jsonObj */
var jsonObj =
{
    "articles": [
        {
            "id":"",
            "topic":"",
            "title":"",
            "summary":"",
            "content":"",
            "imgUrl":"" },
        {
            "id":"",
            "topic":"",
            "title":"",
            "summary":"",
            "content":"",
            "imgUrl":"" }
    ]
}


function wonload(topic)
{
    counter = 1;
    var xmlhttp;

    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("GET","../article/searching?counter=" + counter + "&recordNum="
        + recordNum + "&topic=" + topic , false);
    xmlhttp.send();

    var jsonStr =xmlhttp.responseText;
    jsonObj = eval ("(" + jsonStr + ")");
    var article = document.createElement('div');
    var content = "";
    for(var i = 0; i < recordNum; i++){
        num ++;
        content +=
            "<li class='article' id='" + i + "' onclick='getArticleDetail("  + i + ")'>" +
            "<div class='articleImg'>" +
                //"<a href=''>" +
            "<img src='" + jsonObj.articles[i].imgUrl + "'>" +
                //"</a>" +
            "</div>" +

            "<div class='articleContent'>" +
            "<div class='articleTitle'>" +
            num + "." + jsonObj.articles[i].title +
            "</div>" +

            "<div class='ctText'>" +
                //"<a href=''>" +
            jsonObj.articles[i].content +
                //"</a>" +
            "</div>" +
            "</div>" +
            "</li>";
    }
    article.innerHTML = content;
    document.getElementById("articleBox").appendChild(article);
}

function loadXMLDoc()
{
    counter++;

    var xmlhttp;

    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("GET","../article/searching?counter=" + counter + "&recordNum="
        + recordNum + "&topic=" + topic , false);
    xmlhttp.send();

    var jsonStr =xmlhttp.responseText;
    jsonObj = eval ("(" + jsonStr + ")");
    var article = document.createElement('div');
    var content = "";
    for(var i = 0; i < recordNum; i++){
        num++;
        content +=
            "<li class='article' id='" + i + "' onclick='getArticleDetail("  + i + ")'>" +
            "<div class='articleImg'>" +
            //"<a href=''>" +
            "<img src='" + jsonObj.articles[i].imgUrl + "'>" +
            //"</a>" +
            "</div>" +

            "<div class='articleContent'>" +
            "<div class='articleTitle'>" +
            num + "." + jsonObj.articles[i].title +
            "</div>" +

            "<div class='ctText'>" +
            //"<a href=''>" +
            jsonObj.articles[i].content +
            //"</a>" +
            "</div>" +
            "</div>" +
            "</li>";
    }
    article.innerHTML = content;
    document.getElementById("articleBox").appendChild(article);
}


function getArticleDetail(id)
{
    var body = document.getElementById('ibody');
    body.innerHTML = "<div class='caseTitle' id='ctitle'></div>"
    + "<div class='caseSummary' id='csummary'></div>"
    + "<div class='caseText' id='ctext'></div>";

    document.getElementById("ctitle").innerHTML = jsonObj.articles[id].title;
    document.getElementById("csummary").innerHTML = jsonObj.articles[id].summary;
    document.getElementById("ctext").innerHTML = jsonObj.articles[id].content;

}
