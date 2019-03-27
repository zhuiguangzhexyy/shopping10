$(document).ready(function () {
    //分类获取所有类型
    var selectAllTypeForOrder = function () {
        $.ajax({
            url:"/shopping10/type/selectAllTypeForOrder",
            data:{},
            dataType:"json",
            type:"post",
            success:function (data) {
                for(var i = 0;i<data.length;i++){
                    var $dt = $("<dt>"+data[i][0].type_name+"</dt>");
                    $("#index_dl").append($dt);
                    for(var j = 1;j<data[i].length;j++){

                        var $dd = $("<dd>" +
                            "<a href='#'>"+data[i][j].type_name+"</a>"+
                            "</dd>");
                        $("#index_dl").append($dd);
                    }

                }
            },
            error:function () {
                alert("请求失败");
            }
        });
    };
    selectAllTypeForOrder();
});