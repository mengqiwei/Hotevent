
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<div>
    <input type="hidden" name="pageIndex" value="1" id="pageIndex">
    <input type="text" name="keyWord" id="keyWord" value="${param.keyWord}">
    <input type="button" value="查询" onclick="toPage(1)">
</div>
<table border="1"></table>
<div id="info"></div>
<div id="idinfo"></div>

</body>
</html>
<script src="statics/js/jquery-1.12.4.js"></script>
<script>
    $(function () {
        showAjax(1);



    });
function showAjax(pageIndex) {
    var keyWord=$("#keyWord").val();
    //var pageIndex=$("#pageIndex").val();
    $.ajax({
        url:"/showAjax",
        data:"keyWord="+keyWord+"&pageIndex="+pageIndex,
        success:function (result) {
            $("table").html("");
            var table="<tr style='background-color: #faff9e'><th>关键词</th><th>搜索指数</th><th>创建时间</th></tr>";
            for (var i=0;result.list.length>i;i++){
                table += '<tr><td><a href="javascript:location.href=\'/info/'+result.list[i].id+'\'">'+result.list[i].keyWord+'</ahref></td><td>'+result.list[i].searchSum+'</td><td>'+result.list[i].createDate+'</td></tr>';
            }

            $("table").html(table);

            var info="";
            if(result.pageIndex!=1){
                info+=' <a href="javascript:toPage(1)">首页</a> <a href="javascript:toPage('+(result.pageIndex-1)+')">上一页</a>';
            }
           if(result.pageIndex<result.totalPage){
               info+=' <a href="javascript:toPage('+(result.pageIndex+1)+')">下一页</a>  <a href="javascript:toPage('+result.totalPage+')">末页</a>';
            }
            info+='第'+result.pageIndex+'页共'+result.totalPage+'页';

            $("#info").html(info);
        }
    });
}
    function toPage(pageIndex) {
        $("#pageIndex").val(pageIndex);

        //$("form").submit();
        showAjax(pageIndex);
    }
    
    function toinfo(id) {

    }
</script>