
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <style>
        p{
            background-color: #f5d2c3;
        }
    </style>
</head>
<body>
<input type="hidden" name="id" id="id" value="${id}">
<div id="info"></div>
<div id="infoall"></div>
<div id="pl">
    快速评论:
    <textarea name="content" id="content" cols="30" rows="6"></textarea><span id="tep"></span>
    <input type="button" value="提交" onclick="sub()">
    <input type="button" value="返回首页" onclick="history.back(-1)">
</div>

</body>
</html>
<script src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
<script>

    $(function () {
        var id=$("#id").val();
       $.ajax({
           url:"/showinfo",
           data:"id="+id,
           success:function (result) {
               var info="";
               $("#info").html("");
               info+="<h1>"+result.keyWord+"</h1>";
               info+="创建于:"+result.createDate+"<br\><br\>";
               info+=result.hotContent;

               $("#info").html(info);
           }
       });

        $.ajax({
            url:"/showinfoAll",
            data:"id="+id,
            success:function (result) {
                var infoall="<h3>评论</h3>";
                $("#infoall").html("");
                for (var i=0;result.length>i;i++){

                    infoall+="<p>评论时间: "+result[i].commentDate+"<br/>"+result[i].content+"</p>";
                }
                $("#infoall").html(infoall);
            }
    });

    });
function sub() {
    var id=$("#id").val();
    var content= $("#content").val();
    if (content=="" || content==null){
        $("#tep").text("请填写评论内容");
        return;
    }else{
        $("#tep").text("");
    }
    location.href="/insert?content="+content+"&hotEventsId="+id;
}
</script>