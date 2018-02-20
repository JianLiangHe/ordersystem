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
            <h3 class="panel-title">用户列表</h3>
        </div>
        <div class="panel-body">
            <form id="frm">
                工号:<input name="querys" type="text">
                状态:<input name="querys" type="text">
                时间范围:<input name="querys" type="date">-<input name="querys" type="date">
            </form>
            <table id="tab" class="table table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>工号</th>
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
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="userInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        用户详细信息
                    </h4>
                </div>
                <div class="modal-body">
                    <table id="userInfoTab" width="320" cellspacing="1" cellpadding="1" align="center">

                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="updateUserInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModal">
                        修改用户信息
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="updateUserTab">
                    <table id="updateUserInfoTab" width="320" cellspacing="1" cellpadding="1" align="center">

                    </table>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" onclick="updateUser();">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</body>
</html>
<script type="text/javascript">

    window.onload = loadData();

    function loadData(num){
        num = num==null?1:num;
        var url = "${pageContext.request.contextPath}/userController/doFindUserForPage?page="+num;
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
                    opt += "<td>"+v.account+"</td>";
                    opt += "<td>"+(v.status==1?'启用':'注销')+"</td>";
                    opt += "<td>"+v.createtime.substring(0,10)+"</td>";
                    opt += "<td>";
                    opt += "<a data-toggle='modal' data-target='#userInfoModal' onclick='findUserInfo("+v.no+");'>详情</a>&nbsp;|&nbsp;";
                    opt += "<a data-toggle='modal' data-target='#updateUserInfoModal' onclick='findUserInfoForUpdate("+v.no+")'>更新</a>";
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

    //查询用户详细信息
    function findUserInfo(no){
        var url = "${pageContext.request.contextPath}/userController/doFindUserInfo?no="+no;
        $.get(url,null,function(data){
            $("#userInfoTab tr").remove();
            var dto = data;
            if(dto.code==200){
                var user = dto.value;
                var opt = "<tr><td>工号:</td> <td>"+user.account+"</td></tr>";
                opt += "<tr><td>密码:</td> <td>"+user.password+"</td>"
                opt += "<tr><td>权限:</td> <td>"+user.privilege+"</td>";
                opt += "<tr><td>创建时间:</td> <td>"+user.createtime.substring(0,10)+"</td>";
                opt += "<tr><td>状态:</td> <td>"+(user.status==1?'启用':'禁用')+"</td>";
                $("#userInfoTab").append(opt);
            }else{
                alert(dto.message);
            }
        },"json");
    }

    //查询用户详细信息（修改模态框）
    function findUserInfoForUpdate(no){
        var url = "${pageContext.request.contextPath}/userController/doFindUserInfo?no="+no;
        $.get(url,null,function(data){
            $("#updateUserInfoTab tr").remove();
            var dto = data;
            if(dto.code==200){
                var user = dto.value;
                var opt = "<tr><td>工号:</td> <td><input name='no' type='hidden' value='"+user.no+"'><input name='account' value='"+user.account+"'></td></tr>";
                opt += "<tr><td>密码:</td> <td><input name='password' value='"+user.password+"'></td>"
                opt += "<tr><td>权限:</td> <td><input name='privilege' value='"+user.privilege+"'></td>";
                opt += "<tr><td>创建时间:</td> <td><input name='createtime' type='date' value='"+(user.createtime.substring(0,10))+"'></td>";
                opt += "<tr><td>状态:</td> <td><input name='status' value='"+user.status+"'></td>";
                $("#updateUserInfoTab").append(opt);
            }else{
                alert(dto.message);
            }
        },"json");
    }

    //修改用户信息
    function updateUser(){
        var url = "${pageContext.request.contextPath}/userController/doUpdateUser";
        var params = $("#updateUserTab").serialize();
        $.get(url,params,function(data){
            alert(data.message);
            loadData();
        });
    }
</script>
