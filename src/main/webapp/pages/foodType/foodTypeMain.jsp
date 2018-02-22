<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/2/15
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        .table {font-size: 12px;}
        #frm input {width: 120px;}
    </style>
</head>
<body>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">食品类型列表</h3>
        </div>
        <div class="panel-body">
            <table id="tab" class="table table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>食品类型名称</th>
                    <th>状态</th>
                    <th>创建时间</th>
                    <th>管理</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
<script type="text/javascript">

    window.onload = loadData();

    function loadData(num){
        num = num==null?1:num;
        var url = "${pageContext.request.contextPath}/foodTypeController/doFindFoodTypeForPage?page="+num;
        var params = $("#frm").serialize();
        $.get(url,params,function(data){
            if(data.result!=null){
                $("#tab tbody tr").remove();
                var page = data.page;
                var totalCount = data.totalCount;
                var totalPage = data.totalPage;
                $.each(data.result,function(i,v){
                    var opt = "<tr>";
                    opt += "<td>"+(i+1)+"</td>";
                    opt += "<td>"+v.name+"</td>";
                    opt += "<td>"+(v.status==1?'启用':'注销')+"</td>";
                    opt += "<td>"+v.createtime.substring(0,10)+"</td>";
                    opt += "<td>";
                    if(v.status==1){
                        opt += "<a href='javascript:updateFoodTypeStatus("+v.no+",0);'>注销</a>";
                    }else{
                        opt += "<a href='javascript:updateFoodTypeStatus("+v.no+",1);'>启用</a>";
                    }
                    opt += "</td>";
                    opt += "</tr>";

                    $("#tab tbody").append(opt);
                });
                var opt = "<tr>";
                opt += "<td colspan='5' align='center'>";
                opt += "共查询出"+totalCount+"条数据,共"+totalPage+"页,当前第"+page+"页";
                opt += "<a href='javascript:loadData("+(page<=1?1:page-1)+");'>上一页</a>&nbsp;";
                opt += "<a href='javascript:loadData("+(page<totalPage?page+1:totalPage)+");'>下一页</a>";
                opt += "</td>";
                opt += "</tr>";
                $("#tab tbody").append(opt);
            }
        },"json");
    }

    //更新食品类型状态
    function updateFoodTypeStatus(no,statusNum){
        var url = "${pageContext.request.contextPath}/foodTypeController/doUpdateFoodTypeStatus";
        var params = {"no":no,"statusNum":statusNum};
        $.get(url,params,function(data){
            loadData();
        },"json");
    }
</script>
