$(document).ready(function () {
    //查询所有商品大类型
    var getAllBigType=function () {
        $.ajax({
            url:"shopping10/type/selectAllBigType",
            data:{},
            dataType:"json",
            type:"post",
            success:function (data) {
                for(var i=0;i<data.length;i++){
                   var $li=$("<li class='first'><a href='#'>"+data[i].type_name+"</a></li>");
                   $("#BigType").append($li);
                }
            },
            error:function () {
                alert("请求失败")
            }
        });
        getAllBigType();
    };

    //点击注销功能
    $("#logout").click(function () {
        $.ajax({
            url:"/shopping10/user/logout",
            data:"",
            dataType:"text",
            type:"post",
            success:function (data) {
                if(data=="注销成功"){
                    self.location.href="/shopping10/jsp/index.jsp"
                }
            },
            error:function () {
                alert("由于网络原因,注销失败");
            }
        });
        //强制阻止所有事件
        return false;

    });
});